package com.example.community.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapters.ChatAdapter
import com.example.community.R
import com.example.helpers.SendMessageInBg
import com.example.interfaces.BotReply
import com.example.models.Message
import com.google.api.gax.core.FixedCredentialsProvider
import com.google.auth.oauth2.GoogleCredentials
import com.google.auth.oauth2.ServiceAccountCredentials
import com.google.cloud.dialogflow.v2.*
import com.google.common.collect.Lists
import java.io.InputStream
import java.util.*


class MainActivity : AppCompatActivity(), BotReply {

    var chatView: RecyclerView? = null
    var chatAdapter: ChatAdapter? = null
    var messageList: MutableList<Message> = ArrayList()
    var editMessage: EditText? = null
    var btnSend: ImageButton? = null

    //dialogFlow
    private var sessionsClient: SessionsClient? = null
    private var sessionName: SessionName? = null
    private val uuid: String = UUID.randomUUID().toString()
    private val TAG = "mainactivity"


    private val fragmentManager: FragmentManager? = null
    private val btn_mypage: Button? = null
    private val btn_register: Button? = null
    private val et_id: EditText? = null
    private val et_password: EditText? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_mypage = findViewById<ImageButton>(R.id.btn_mypage)
        btn_mypage.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
        val btn_search = findViewById<ImageButton>(R.id.btn_search)
        btn_search.setOnClickListener {
            val intent = Intent(applicationContext, ResultActivity::class.java)
            startActivity(intent)
        }
        val btn_community = findViewById<View>(R.id.btn_community) as Button
        btn_community.setOnClickListener {
            val intent = Intent(applicationContext, CommunityActivity::class.java)
            startActivity(intent)
        }
        val btn_chatbot = findViewById<View>(R.id.btn_chatbot) as ImageButton
        btn_chatbot.setOnClickListener {
            val intent = Intent(applicationContext, ChatbotActivity::class.java)
            startActivity(intent)
        }

        chatView = findViewById(R.id.chatView);
        editMessage = findViewById(R.id.editMessage);
        btnSend = findViewById(R.id.btn_send);


        chatAdapter = ChatAdapter(messageList, this)
        chatView?.adapter = chatAdapter

        btnSend?.setOnClickListener(View.OnClickListener {
            val message = editMessage?.text.toString()
            if (!message.isEmpty()) {
                messageList.add(Message(message, false))
                editMessage?.setText("")
                sendMessageToBot(message)
                Objects.requireNonNull(chatView?.adapter).notifyDataSetChanged()
                Objects.requireNonNull(chatView?.layoutManager)
                    ?.scrollToPosition(messageList.size - 1)
            } else {
                Toast.makeText(this@MainActivity, "텍스트를 입력해 주세요", Toast.LENGTH_SHORT).show()
            }
        })
        setUpBot()
    }
    private fun setUpBot() {
        try {
            val stream: InputStream = this.resources.openRawResource(R.raw.credential)
            val credentials: GoogleCredentials = GoogleCredentials.fromStream(stream)
                .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"))
            val projectId = (credentials as ServiceAccountCredentials).projectId

            val settingsBuilder: SessionsSettings.Builder = SessionsSettings.newBuilder()
            val sessionsSettings: SessionsSettings = settingsBuilder.setCredentialsProvider(
                FixedCredentialsProvider.create(credentials)
            ).build()
            sessionsClient = SessionsClient.create(sessionsSettings)
            sessionName = SessionName.of(projectId, uuid)

            Log.d(TAG, "projectId : $projectId")
        } catch (e: Exception) {
            Log.d(TAG, "setUpBot: " + e.message)
        }
    }

    private fun sendMessageToBot(message: String) {
        val input: QueryInput = QueryInput.newBuilder()
            .setText(TextInput.newBuilder().setText(message).setLanguageCode("ko-KR")).build()
        SendMessageInBg(this, sessionName, sessionsClient, input).execute()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun callback(returnResponse: DetectIntentResponse?) {
        if (returnResponse != null) {
            val botReply: String = returnResponse.getQueryResult().getFulfillmentText()
            if (!botReply.isEmpty()) {
                messageList.add(Message(botReply, true))
                chatAdapter?.notifyDataSetChanged()
                Objects.requireNonNull(chatView!!.layoutManager)
                    ?.scrollToPosition(messageList.size - 1)
            } else {
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "failed to connect!", Toast.LENGTH_SHORT).show()
        }
    }
}