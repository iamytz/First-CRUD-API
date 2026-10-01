package com.colonia.CrudBasic.Service;

import com.colonia.CrudBasic.Database.Dto.ProdutoDto;
import com.colonia.CrudBasic.Database.Entity.ProdutoEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProdutoService {

    private static final ArrayList<ProdutoEntity> PRODUTOS = new ArrayList<>();
    static {
        PRODUTOS.add(ProdutoEntity.builder().id(1).name("IPhone 67 Prox Max").price(20000f).quantity(10).build());
        PRODUTOS.add(ProdutoEntity.builder().id(2).name("Notebook Gamer").price(7000f).quantity(10).build());
        PRODUTOS.add(ProdutoEntity.builder().id(3).name("Playstation 6").price(12000f).quantity(10).build());
    }

    public ResponseEntity<ArrayList<ProdutoEntity>> listarProdutos() {
       return new ResponseEntity<>(PRODUTOS,HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<ProdutoEntity> findById(int id) {
        return new ResponseEntity<>(PRODUTOS.stream().filter(produto -> produto.getId().equals(id)).findFirst().orElse(null), HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<ProdutoEntity> createProduct(ProdutoDto dto) {
        int genaratedId = PRODUTOS.stream().mapToInt(ProdutoEntity::getId).max().orElse(0)+1;
        ProdutoEntity novoProduto = ProdutoEntity.builder().id(genaratedId).name(dto.getName()).price(dto.getPrice()).quantity(dto.getQuantity()).build();
        PRODUTOS.add(novoProduto);
        return new ResponseEntity<>(novoProduto,HttpStatusCode.valueOf(201));
    }

    public ResponseEntity<ProdutoEntity> editById(int id, ProdutoDto dto) {
    ProdutoEntity produto = PRODUTOS.stream().filter(prod -> prod.getId().equals(id)).findFirst().orElse(null);
    produto.setName(dto.getName());
    produto.setPrice(dto.getPrice());
    produto.setQuantity(dto.getQuantity());
    return new ResponseEntity<>(produto,HttpStatusCode.valueOf(201));
    }

    public HttpStatusCode deleteProduct(int id) {
        ProdutoEntity produto = PRODUTOS.stream().filter(prod -> prod.getId().equals(id)).findFirst().orElse(null);
        PRODUTOS.remove(produto);
        return HttpStatusCode.valueOf(200);
    }

};
