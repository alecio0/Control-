<%  if(session.getAttribute("user") != null){ response.sendRedirect("index.jsp"); } %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Control+</title>
    <link rel="stylesheet" href="estilos/main.css">
    <link rel="stylesheet" href="estilos/icomoon/style.css"></head>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<body>
    <main>
        <content select="">
            <section>
                <div class="wrap">
                    <form action="ControleServlet" class="formulario" name="form_login" method="post">
                        <h2 class="h-form">Bem Vindo</h2>
                        <div>
                            <div class="input-group">
                                <input type="text" id="login" name="login">
                                <label class="label" for="login">Login...</label>
                            </div>
                            <div class="input-group">
                                <input type="password" id="senha" name="senha">
                                <label class="label" for="sena">Senha...</label>
                            </div>
                            <input type="hidden" name="logica" value="Login"/>
                            <div class="left">
                                <button type="submit" name="button"><i class="icon-checkmark2"> Entrar</i></button>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
        </content>
    </main>
    <script>
        (function(){

        var formulario = document.form_login,
            elementos = formulario.elements;

        // Funcion que se ejecuta cuando el evento click es activado

        var validarInputs = function(){
            for (var i = 0; i < elementos.length; i++) {
                // Identificamos si el elemento es de tipo texto, email, password, radio o checkbox
                if (elementos[i].type == "text" || elementos[i].type == "email" || elementos[i].type == "password" || elementos[i].type == "tel") {
                    // Si es tipo texto, email o password vamos a comprobar que esten completados los input
                    if (elementos[i].value.length == 0) {
                        console.log('El campo ' + elementos[i].name + ' esta incompleto');
                        elementos[i].className = elementos[i].className + " error";
                        return false;
                    } else {
                        elementos[i].className = elementos[i].className.replace(" error", "");
                    }
                }
            }

            return true;
        };

        var enviar = function(e){
            if (!validarInputs()) {
                console.log('Falto validar los Input');
                e.preventDefault();
            } else {
                console.log('Envia');
                // e.preventDefault();
            }
        };

        var focusInput = function(){
            this.parentElement.children[1].className = "label active";
            this.parentElement.children[0].className = this.parentElement.children[0].className.replace("error", "");
        };

        var blurInput = function(){
            if (this.value <= 0) {
                this.parentElement.children[1].className = "label";
                this.parentElement.children[0].className = this.parentElement.children[0].className + " error";
            }
        };

        // --- Eventos ---
        formulario.addEventListener("submit", enviar);

        for (var i = 0; i < elementos.length; i++) {
            if (elementos[i].type == "text" || elementos[i].type == "email" || elementos[i].type == "password" || elementos[i].type == "tel") {
                elementos[i].addEventListener("focus", focusInput);
                elementos[i].addEventListener("blur", blurInput);
            }
        }

        }())
    </script>
</body>
</html>
