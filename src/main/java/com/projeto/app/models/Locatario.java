package com.projeto.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locatario {

    // INFORMAÇÕES PESSOAIS DO LOCÁTARIO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String nome;
        private Long cpf;
        private String endereco;
        private String email;
        private Long telefone;

     // CONSTRUCTOR   
        public Locatario(String nome, Long cpf, String endereco, String email, Long telefone) {
            this.nome = nome;
            this.cpf = cpf;
            this.endereco = endereco;
            this.email = email;
            this.telefone = telefone;
        }
    // GET E SET
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Long getCpf() {
            return cpf;
        }

        public void setCpf(Long cpf) {
            this.cpf = cpf;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Long getTelefone() {
            return telefone;
        }

        public void setTelefone(Long telefone) {
            this.telefone = telefone;
        }
    






    
}