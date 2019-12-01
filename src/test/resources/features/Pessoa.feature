Feature: Create Employee

  Scenario Outline: <casoDeTeste> <resultadoEsperado>

    Given que os usuarios devem realizar acoes no sistema
      | codigo  | nome   | cpf   |
      | 110     | <nome> | <cpf> | 

    And possuem o numeros de telefone
      | ddd   | numero    |
      | <ddd> | <telefone>  |
      
    And os enderecos
      |logradouro   | numero   | complemento   | bairro   | cidade  | estado  |
      |<logradouro> | <numero> | <complemento> | <bairro> | <cidade>| <estado>|
      
    When for submetido o cadastro dos dados 
    Then o status de resposta deve ser <statusCode>
    And  sera apresentado mensagem <msgResult> 

    Examples:
      | casoDeTeste             |resultadoEsperado| statusCode | nome             | cpf            | logradouro           | numero  | complemento | bairro                |cidade   |estado | ddd | telefone | msgResult                                        |
      | Cadastro de pessoa      |SUCESS           | 201        | Rafael Teixeira  | 31334003041    | Rua Alexandre Dumas  | 123     | Empresa     | Chacara Santo Antonio | Brasilia|DF     | 61  | 991296634|                                                  |
      | CPF ja existe           |FAIL             | 400        | Jefferson Bruno  | 31334003041    | Rua 8 Parque Esplan  | 109     | Casa        | Parque                | Valpa   |GO     | 62  | 992231511|Já existe pessoa cadastrada com o CPF %s          |
      | Telefone ja existe      |FAIL             | 400        | Bruna Carvalho   | 59816079046    | Quadra mista 6       | 13      | Apartamento | Setor Sudoeste        | Cruzeiro|DF     | 61  | 991296634|Já existe pessoa cadastrada com o Telefone (%s)%s |
      | Cadastro de nova pessoa |SUCESS           | 201        | Vivian Azevedo   | 03187339000    | Quadra 403 Cj0       | 42      | Casa        | Recanto das Emas      | Recanto |DF     | 61  | 996352212|                                                  |

	Scenario Outline: Consultar pessoa <situacaoCadastro>
	
		Given que o usuario deseja realizar uma consulta de pessoa <situacaoCadastro>
		When for relalizado a consulta
		Then o status de resposta deve ser <statusCode>
		And os dados retornados devem estar corretos casa esteja cadastrada
		And sera apresentado mensagem <msgResult>
		
	 Examples:
	 | situacaoCadastro |statusCode|msgResult                              |
	 | Cadastrada       | 200      |                                       |
	 | Nao cadastrada   | 404      |Não existe pessoa com o telefone (%s)%s|
		
		
