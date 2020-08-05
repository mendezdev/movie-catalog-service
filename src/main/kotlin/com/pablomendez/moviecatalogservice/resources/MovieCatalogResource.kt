package com.pablomendez.moviecatalogservice.resources

import com.pablomendez.moviecatalogservice.models.CatalogItem
import com.pablomendez.moviecatalogservice.models.Rating
import com.pablomendez.moviecatalogservice.models.Movie
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.util.stream.Collectors

@RestController
@RequestMapping("/catalog")
class MovieCatalogResource {
    @GetMapping("/{userId}")
    fun getCatalog(@PathVariable userId: String): List<CatalogItem> {

        val restTemplate = RestTemplate()

        val ratings = listOf(
                Rating("1234", 4),
                Rating("9876", 6))

        return ratings.stream().map {
            val movie = restTemplate.getForObject("http://localhost:8082/movies/${it.movieId}", Movie::class.java)
            CatalogItem(movie!!.name, "desc", it.rating)
        }.collect(Collectors.toList())
    }
}