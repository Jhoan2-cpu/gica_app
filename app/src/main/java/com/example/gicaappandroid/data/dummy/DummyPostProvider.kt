package com.example.gicaappandroid.data.dummy

import com.example.gicaappandroid.data.model.Post
import com.example.gicaappandroid.data.model.Rendered

object DummyPostProvider {
    val dummyPosts = listOf(
        Post(
            id = 1,
            title = Rendered("¿Por qué elegir GICA Ingenieros?"),
            excerpt = Rendered("Conoce los beneficios y ventajas de estudiar con nosotros.")
        ),
        Post(
            id = 2,
            title = Rendered("Nuestros cursos online"),
            excerpt = Rendered("Explora nuestra oferta educativa con docentes certificados.")
        ),
        Post(
            id = 3,
            title = Rendered("Contacto y soporte"),
            excerpt = Rendered("Estamos aquí para ayudarte. Escríbenos por WhatsApp o correo.")
        ),
        Post(
            id = 4,
            title = Rendered("Historia de GICA"),
            excerpt = Rendered("Desde nuestros inicios hasta la actualidad.")
        ),
        Post(
            id = 5,
            title = Rendered("Testimonios de alumnos"),
            excerpt = Rendered("Conoce lo que opinan nuestros egresados.")
        )
    )
}