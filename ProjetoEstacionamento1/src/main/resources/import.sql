insert into usuario(datanascimento,email, gestante, nome, pcd, perfil, senha)values('1999-09-03', 'ariel@gmail.com', 'N', 'Ariel',  'N', 'ADM', '123');

insert into vagas(status, tipo)values('L', 'C');
insert into vagas(status, tipo)values('O', 'EG');
insert into vagas(status, tipo)values('L', 'EI');
insert into vagas(status, tipo)values('O', 'E');
insert into vagas(status, tipo)values('O', 'C');
insert into vagas(status, tipo)values('L', 'C');


insert into intermediaria(usuario_id, data, hora, vagas_id)values(1, '2022-05-26', '09:00:00', 2);
insert into intermediaria(usuario_id, data, hora, vagas_id)values(3, '2022-05-23', '09:00:00', 1);
insert into intermediaria(usuario_id, data, hora, vagas_id)values(2, '2022-05-25', '09:00:00', 3);
insert into intermediaria(usuario_id, data, hora, vagas_id)values(3, '2022-05-22', '09:00:00', 5);
insert into intermediaria(usuario_id, data, hora, vagas_id)values(4, '2022-05-21', '09:00:00', 4);
insert into intermediaria(usuario_id, data, hora, vagas_id)values(6, '2022-05-20', '09:00:00', 6);