<%@include file="header.jsp" %>
      <content select="">
        <section>
          <div class="sela">
            <div class="tab">
              <table>
                <caption class="h-form">
                  <h2>Clientes</h2>
                  <div><a href="clientes.html" class="h-form"><i class="icon-pencil"></i> </a><a href="clientes.html" class="h-form"><i class="icon-bin"></i> </a>
                  </div>
                </caption>
                <thead class="h-form">
                  <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Endereço</th>
                    <th>Cidade</th>
                  </tr>
                </thead>
                <tbody></tbody>
                <tr>
                  <td>4</td>
                  <td>Fulano das Neves</td>
                  <td>9181 - 1314
                  </td>
                  <td>QNO1 conjuto i casa 2A
                  </td>
                  <td>Ceilandeia-Sul</td>
                  <td><a href="clientes.html" class="h-form"><i class="icon-pencil"></i> </a>
                  </td>
                  <td><a href="clientes.html" class="h-form"><i class="icon-user-minus"></i> </a>
                  </td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Fulano das Neves</td>
                  <td>9282 - 2324
                  </td>
                  <td>QNO2 conjuto i casa 4A
                  </td>
                  <td>Ceilandeia-Sul</td>
                  <td><a href="clientes.html" class="h-form"><i class="icon-pencil"></i> </a>
                  </td>
                  <td><a href="clientes.html" class="h-form"><i class="icon-user-minus"></i> </a>
                  </td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Fulano das Neves</td>
                  <td>9383 - 3334
                  </td>
                  <td>QNO3 conjuto i casa 6A
                  </td>
                  <td>Ceilandeia-Sul</td>
                  <td><a href="clientes.html" class="h-form"><i class="icon-pencil"></i> </a>
                  </td>
                  <td><a href="clientes.html" class="h-form"><i class="icon-user-minus"></i> </a>
                  </td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>Fulano das Neves</td>
                  <td>9484 - 4344
                  </td>
                  <td>QNO4 conjuto i casa 8A
                  </td>
                  <td>Ceilandeia-Sul</td>
                  <td><a href="clientes.html" class="h-form"><i class="icon-pencil"></i> </a>
                  </td>
                  <td><a href="clientes.html" class="h-form"><i class="icon-user-minus"></i> </a>
                  </td>
                </tr>
              </table>
            </div>
            <div class="form-conj">
              <div class="wrap">
                <form action="clientes.html" name="form_cad_cli" class="formulario">
                  <h2 class="h-form">Novo Cliente</h2>
                  <div>
                    <div class="input-group">
                      <input type="text" id="nome" name="nome"/>
                      <label for="nome" class="label">Nome</label>
                    </div>
                    <div class="input-group">
                      <input type="tel" id="telefone" name="telefone"/>
                      <label for="telefone" class="label">Telefone</label>
                    </div>
                    <div class="input-group">
                      <input type="text" id="endereco" name="endereco"/>
                      <label for="endereco" class="label">Endereço</label>
                    </div>
                    <div class="input-group radio">
                      <h3 class="h-form">Cidade / Bairro</h3>
                      <input type="radio" name="cidade" id="ceilandeia-sul" value="Ceilandeia-Sul"/>
                      <label for="ceilandeia-sul">Ceilandeia-Sul</label>
                      <input type="radio" name="cidade" id="taguatinga" value="Taguatinga"/>
                      <label for="taguatinga">Taguatinga</label>
                      <input type="radio" name="cidade" id="ceilandeia-norte" value="Ceilandeia-Norte"/>
                      <label for="ceilandeia-norte">Ceilandeia-Norte</label>
                    </div>
                    <div class="left">
                      <button><i class="icon-user-plus"></i> Adicionar
                      </button>
                    </div>
                  </div>
                </form>
              </div>
              <div class="wrap">
                <form action="clientes.html" name="form_pesq_cli" class="formulario">
                  <h2 class="h-form">Pesquisar Clientes</h2>
                  <div>
                    <div class="input-group">
                      <input type="tel" id="telefonep" name="telefonep"/>
                      <label for="telefonep" class="label">Telefone</label>
                    </div>
                  </div>
                  <div class="left">
                    <button><i class="icon-search"></i> Pesquisar
                    </button>
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
    <script src="js/cliente.js"></script>
  </body>
</html>