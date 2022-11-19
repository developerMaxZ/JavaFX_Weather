package com.example.javafx_weather

import javafx.application.Application
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle

private var xOffset = 0.0
private var yOffset = 0.0

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        stage.initStyle(StageStyle.UNDECORATED)
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 300.0, 680.0)
        stage.title = "Hello!"
        scene.fill = null
        stage.scene = scene
        stage.isResizable
        stage.show()
        stage.x = 980.0
        scene.onMousePressed = EventHandler { event ->
            xOffset = stage.x - event.screenX
            yOffset = stage.y - event.screenY
        }
        scene.onMouseDragged = EventHandler { event ->
            stage.x = event.screenX + xOffset
            stage.y = event.screenY + yOffset
        }
    }
}
    fun main() {
        Application.launch(HelloApplication::class.java)
}
//0fdcfd8bbd14f81ee72b8bd50fc2d1af