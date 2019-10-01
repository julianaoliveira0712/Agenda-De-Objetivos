package br.com.bandtec.AgendaDeObjetivos.modelos;


import javax.persistence.Embeddable;

    @Embeddable
    public class Prioridade {

        private String nome;
        private String observacoes;

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getObservacoes() {
            return observacoes;
        }

        public void setObservacoes(String observacoes) {
            this.observacoes = observacoes;
        }

        protected Prioridade() {}

        public Prioridade(String nome, String observacoes) {
            super();
            this.nome = nome;
            this.observacoes = observacoes;
        }

        public String getNome() {
            return nome;
        }
}
