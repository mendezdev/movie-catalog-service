package com.pablomendez.moviecatalogservice.resources

import com.pablomendez.moviecatalogservice.models.CatalogItem
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/catalog")
class MovieCatalogResource {
    @GetMapping("/{userId}")
    fun getCatalog(@PathVariable userId: String): List<CatalogItem> {
        return listOf(CatalogItem("Transformers", "Test", 4))
    }
}