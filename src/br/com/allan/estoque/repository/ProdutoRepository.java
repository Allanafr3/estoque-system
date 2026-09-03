package br.com.allan.estoque.repository;
import java.util.List;
import br.com.allan.estoque.model.Produto;
//assinatura dos métodos
public interface ProdutoRepository {

    Produto salvar(Produto produto);
    List<Produto> listarTodos();
    Produto buscarPorNome(String nome);
    boolean excluir (String nome);

}
