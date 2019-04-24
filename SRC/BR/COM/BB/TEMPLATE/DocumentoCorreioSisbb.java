package br.com.bb.template;

public abstract class DocumentoCorreioSisbb {

    // TODO: verificar a necessidade de permanecer com essa variável.
    public String arquivo;
    public Object[] parametros;
    

    public void elaborarDocumento(Object... parametros) {
        this.parametros = parametros;

        if (trabalhoPrecisaTemplate()) {
            criarTemplate();
        }
        if (trabalhoPrecisaCarregarDados()) {
            carregarDadosEstatico();
        }
        criarDocumento();
    }

    public abstract void criarDocumento();

    public abstract void carregarDadosEstatico();

    public abstract void criarTemplate();

    public boolean trabalhoPrecisaCarregarDados() {
        return false;
    }

    public boolean trabalhoPrecisaTemplate() {
        return false;
    }

}
