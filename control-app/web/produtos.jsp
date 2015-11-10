<%@include file="header.jsp" %>
      <content select="">
        <section>
          <div class="sela">
            <div class="tab">
              <div class="tabela">
                <table>
                  <caption class="h-form">
                    <h2>Pizzas</h2>
                    <div><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </div>
                  </caption>
                  <thead class="h-form">
                    <tr>
                      <th>ID</th>
                      <th>Nome</th>
                      <th>Venda</th>
                      <th>Custo</th>
                    </tr>
                  </thead>
                  <tbody></tbody>
                  <tr>
                    <td>4</td>
                    <td>Xurisco</td>
                    <td>R$ 27,99</td>
                    <td>R$ 20,99</td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a>
                    </td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>Xurisco</td>
                    <td>R$ 27,99</td>
                    <td>R$ 20,99</td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a>
                    </td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Xurisco</td>
                    <td>R$ 27,99</td>
                    <td>R$ 20,99</td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a>
                    </td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </td>
                  </tr>
                  <tr>
                    <td>1</td>
                    <td>Xurisco</td>
                    <td>R$ 27,99</td>
                    <td>R$ 20,99</td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a>
                    </td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </td>
                  </tr>
                </table>
              </div>
              <div class="tabela">
                <table>
                  <caption class="h-form">
                    <h2>Pizzas</h2>
                    <div><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </div>
                  </caption>
                  <thead class="h-form">
                    <tr>
                      <th>ID</th>
                      <th>Nome</th>
                      <th>Venda</th>
                      <th>Custo</th>
                    </tr>
                  </thead>
                  <tbody></tbody>
                  <tr>
                    <td>4</td>
                    <td>Xurisco</td>
                    <td>R$ 27,99</td>
                    <td>R$ 20,99</td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a>
                    </td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>Xurisco</td>
                    <td>R$ 27,99</td>
                    <td>R$ 20,99</td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a>
                    </td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Xurisco</td>
                    <td>R$ 27,99</td>
                    <td>R$ 20,99</td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a>
                    </td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </td>
                  </tr>
                  <tr>
                    <td>1</td>
                    <td>Xurisco</td>
                    <td>R$ 27,99</td>
                    <td>R$ 20,99</td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-pencil"></i> </a>
                    </td>
                    <td><a href="prosutos.html" class="h-form"><i class="icon-bin"></i> </a>
                    </td>
                  </tr>
                </table>
              </div>
            </div>
            <div class="form-conj">
              <div class="wrap">
                <form action="produtos.html" name="form_cad_pro" method="get" class="formulario">
                  <h2 class="h-form">Novo Produto</h2>
                  <div>
                    <div class="input-group">
                      <input type="text" id="nome" name="nome"/>
                      <label for="nome" class="label">Nome</label>
                    </div>
                    <div class="input-group">
                      <input type="text" id="compra" name="compra"/>
                      <label for="compra" class="label">Custo</label>
                    </div>
                    <div class="input-group">
                      <input type="text" id="venda" name="venda"/>
                      <label for="venda" class="label">Venda</label>
                    </div>
                    <div class="input-group radio">
                      <input id="atendente" type="radio" name="tipo" value="Pizzas"/>
                      <label for="atendente"><i class="icon-"></i> Pizzas
                      </label>
                      <input id="administrador" type="radio" name="tipo" value="Refrigerantes"/>
                      <label for="administrador"><i class="icon-"></i> Refrigerantes
                      </label>
                      <div class="left">
                        <button><i class="icon-checkmark2"></i> Adicionar
                        </button>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
              <div class="wrap">
                <form action="produtos.html" name="form_cad_tip" method="post" class="formulario">
                  <h2 class="h-form">Novo Tipo</h2>
                  <div>
                    <div class="input-group">
                      <input type="text" id="nome" name="nome"/>
                      <label for="nome" class="label">Nome</label>
                    </div>
                    <div class="left">
                      <button><i class="icon-checkmark2"></i> Adicionar
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </section>
        <aside>
        </aside>
      </content>
      <footer>
        <h1 class="logo-mini">Control +</h1>
        <time>10:45</time>
      </footer>
    </main>
    <script src="js/produtos.js"></script>
  </body>
</html>