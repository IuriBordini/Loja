
package sistema.modelo;


public class ItemPedido {
    private long id;
    private Produto produto;
    private int quantidade;
    
    
            public ItemPedido(){
            }
              public ItemPedido(long id,Produto produto, int quantidade){
                  this.id = id;
                  this.produto = produto;
                  this.quantidade = quantidade;
              }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
                
}
