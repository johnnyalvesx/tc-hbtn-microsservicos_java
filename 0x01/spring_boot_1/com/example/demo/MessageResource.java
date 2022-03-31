import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {

	return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT";
    }

    @GetMapping("/login")
    public String login(String user, String senha) {

	user = "Johnny";
	senha = "87654321";

	if (user.isEmpty() || senha.isEmpty()) {
	    return "USUÁRIO E SENHA NÃO INFORMADOS";
	} else if (user.length() > 15 || senha.length() > 15) {
	    return "USUÁRIO E SENHA INVÁLIDOS";
	} else {
	    return "LOGIN EFETUADO COM SUCESSO !!!";
	}
    }
}
