# java-avaliation

Esse é um repositório público feito para meu teste técnico em um processo seletivo.

Endpoints: <br>
http://localhost:8080/pessoas GET - listar todas as Pessoas criadas.<br>
http://localhost:8080/pessoas POST - adicionar uma nova pessoa. Exemplo de payload:<br>
![image](https://user-images.githubusercontent.com/61751830/215225628-91aa8e15-32cf-4904-9b30-0f22da6c660e.png)<br>
http://localhost:8080/pessoas/{id} GET - retornar uma Pessoa específica.<br>
http://localhost:8080/pessoas/{id} PUT - atualizar as informações de uma pessoa. Exemplo de payload: <br>
![image](https://user-images.githubusercontent.com/61751830/215228743-2d2dd3f4-34be-400a-869a-524d813fadbf.png) <br>
http://localhost:8080/pessoas/{id}/endereco POST - adicionar um novo endereço a uma pessoa, tornando o novo endereço como seu principal. Exemplo de payload: <br>
![image](https://user-images.githubusercontent.com/61751830/215228272-a7e6f473-1667-461e-9238-004ce73bee76.png)<br>
http://localhost:8080/pessoas/{id}/endereco GET - retornar todos os endereços cadastrados para uma Pessoa.
http://localhost:8080/pessoas/{id}/endereco/{id}/default PUT - definir um endereço como seu endereço principal.
