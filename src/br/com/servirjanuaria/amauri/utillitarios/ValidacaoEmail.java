package br.com.servirjanuaria.amauri.utillitarios;

public class ValidacaoEmail {

    public boolean validaEmail(String Email) {
        boolean Validacao = true;

        if ((Email.contains("@")) && (Email.contains(".")) && (!Email.contains(" "))) {

            String usuario = new String(Email.substring(0, Email.lastIndexOf('@')));
            String dominio = new String(Email.substring(Email.lastIndexOf('@') + 1, Email.length()));

            if ((usuario.length() >= 1) && (!usuario.contains("@"))
                    && (dominio.contains(".")) && (!dominio.contains("@"))
                    && (dominio.indexOf(".") >= 1)
                    && (dominio.lastIndexOf(".") < dominio.length() - 1)) {
                Validacao = true;
            } else {
                Validacao = false;

            }
        } else {
            Validacao = false;

        }

        return Validacao;
    }

}
