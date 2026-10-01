package com.colonia.CrudBasic.Controller;

import com.colonia.CrudBasic.Database.Dto.ProdutoDto;
import com.colonia.CrudBasic.Database.Entity.ProdutoEntity;
import com.colonia.CrudBasic.Service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProdutosController {
    private final ProdutoService produtoService;

    @GetMapping("/v1/produtos")
    public ResponseEntity<ArrayList<ProdutoEntity>> listarProdtuos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/v1/produtos/{id}")
    public ResponseEntity<ProdutoEntity> findById (@PathVariable int id) {
        return produtoService.findById(id);
    }

    @PostMapping("/v1/produtos")
    public ResponseEntity<ProdutoEntity> createProduct (@RequestBody ProdutoDto dto) {
        return produtoService.createProduct(dto);
    }

    @PutMapping("/v1/produtos/{id}")
    public ResponseEntity<ProdutoEntity> editById(@PathVariable int id, @RequestBody ProdutoDto dto) {
        return produtoService.editById(id, dto);
    }

    @DeleteMapping("/v1/produtos/{id}")
    public HttpStatusCode deleteById(@PathVariable int id) {
        return produtoService.deleteProduct(id);
    }
}
