package pxnx

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.http.content.*
import java.io.File

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)



@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondText("If you read this you are gay.", contentType = ContentType.Text.Plain)
        }

        get("/test") {
            call.respondText("If you read this you are gay.", contentType = ContentType.Text.Plain)
        }

        static("static") {
            resource("test.json")
        }


    }
}

fun Application.main() {
    install(StatusPages){
        statusFile(HttpStatusCode.NotFound, HttpStatusCode.Unauthorized, filePattern = "error#.html")
    }



}

