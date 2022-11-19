package com.example.javafx_weather

import com.google.gson.Gson
import java.net.URL
import java.util.ResourceBundle
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.text.Text
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

@Suppress("UNREACHABLE_CODE")
class HelloController {

    @FXML
    private lateinit var resources: ResourceBundle

    @FXML
    private lateinit var location: URL

    @FXML
    private lateinit var exitButton: Button

    @FXML
    private lateinit var tempKazan: Text

    @FXML
    private lateinit var exit: Button

    @FXML
    fun initialize() {
        val output = (getUrlContent("http://api.openweathermap.org/data/2.5/find?q=Kazan&type=like&APPID=0fdcfd8bbd14f81ee72b8bd50fc2d1af"))
        tempKazan.text = (parsingJson(output,"temp")!!.toDouble()-273.15).toInt().toString() + "°"
        exit.setOnAction {
            exitProcess(0)
        }
    }
    private fun parsingJson(output: String, request: String): String? {
        val gson = Gson()
        val jsonString:String = gson.toJson(output)
        val jsonMassiv = jsonString.split(",", ":").toMutableList()
        for(i in jsonMassiv.indices) {
            if (jsonMassiv[i].replace("\"", "").replace("\\", "").replace("{", "") == request) {
                return jsonMassiv[i+1].replace("\"", "").replace("\\", "").replace("{", "")
            }
        }
        return null
    }
    private fun getUrlContent(urlAdress: String): String {
        val content = StringBuffer()
        try {
            val url = URL(urlAdress)
            val urlConn = url.openConnection()
            val bufferedReader = BufferedReader(InputStreamReader(urlConn.getInputStream()))
            var line: String
            while (true) {
                line = bufferedReader.readLine()
                content.append(line + "\n")
            }
            bufferedReader.close()
        } catch (e: Exception) {
        }
        return content.toString()
    }
}

