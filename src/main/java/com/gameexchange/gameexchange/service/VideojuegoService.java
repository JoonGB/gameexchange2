package com.gameexchange.gameexchange.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gameexchange.gameexchange.domain.Videojuego;
import com.gameexchange.gameexchange.repository.FotoRepository;
import com.gameexchange.gameexchange.repository.VideojuegoRepository;
import com.gameexchange.gameexchange.service.dto.IGDB_API.IGDBResponse;
import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spring.web.json.Json;

import javax.inject.Inject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Created by DAM on 2/5/17.
 */
@Service
@Transactional
public class VideojuegoService {
    private final Logger log = LoggerFactory.getLogger(VideojuegoService.class);

    @Inject
    private VideojuegoRepository videojuegoRepository;

    @Inject
    private FotoRepository fotoRepository;

    public List<IGDBResponse> busquedaVideojuego(String busqueda) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://igdbcom-internet-game-database-v1.p.mashape.com/games/?fields=name,genres,cover&limit=50&offset=0&order=release_dates.date%3Adesc&search="+busqueda)
            .header("X-Mashape-Key", "NxjgTRbXrHmshL7BkVXijTp7WpK7p1XJXkmjsnFDJ46GZFF1kQ")
            .header("Accept", "application/json")
            .asString();
        return jsonToVideojuego(response.getBody());
    }


    private List<IGDBResponse> jsonToVideojuego (String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        List<IGDBResponse> responses = Arrays.asList(gson.fromJson(json, IGDBResponse[].class));

        List<Videojuego> videojuegos = new ArrayList<>();
        for (IGDBResponse igdbResponse : responses) {



        }
        return responses;
        /*List<String> strings = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement elements = parser.parse(json);
        JsonObject object = elements.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = object.entrySet();
        for(Map.Entry<String, JsonElement> entry : entries) {
            strings.add(entry.getKey());
        }
        return strings;*/
    }

    /*private List<Videojuego> jsonToVideojuego(JsonNode json) {
        List<JsonNode> array = (List<JsonNode>) json.getArray();
        for(JsonNode jsonNode : array) {
            jsonNode.get
        }
    }*/


    /*private List<Videojuego> jsonToVideojuego (JsonNode json) {

    }*/
    /*public Optional<Foto> getFotoPrincipal(Long idProducto) {

        Producto producto =  productoRepository.findOne(idProducto);

        if (producto == null) {
            return Optional.empty();
        }


        return  producto.getFotos().stream().findFirst();


    }

    public Set<Foto> getFotos(Long idProducto) {

        Producto producto =  productoRepository.findOne(idProducto);

        if (producto == null) {
            return null;
        }

        return producto.getFotos();

    }

    public List<ProductoDTO> getProductos() {


        return productoRepository.findAll().stream().map(producto ->

            getProductoDTO(producto)


        ).collect(Collectors.toList());

    }

    public ProductoDTO getProductoDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setCreado(producto.getCreado());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setUsuario(producto.getUsuario());
        productoDTO.setFotos(new ArrayList<>(producto.getFotos()));
        productoDTO.setVentas(new ArrayList<>(producto.getVentas()));
        productoDTO.setVideojuego(producto.getVideojuego());

        productoDTO.setFotoPrincipal(getFotoPrincipal(producto.getId()).get());

        return  productoDTO;
    }
    */


}
