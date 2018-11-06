INSERT INTO biker(id, full_name, cpf, address, phone, created_at, updated_at) VALUES (1, 'Rodrigo Batelli Bento', '123.456.789-00', 'Rua Guy de Maupassant, 131', '+5541997202120', TO_DATE('22-12-2018 10:18:02', 'DD-MM-YYYY HH24:MI:SS'), TO_DATE('22-12-2018 10:18:02', 'DD-MM-YYYY HH24:MI:SS'));
INSERT INTO biker(id, full_name, cpf, address, phone, created_at, updated_at) VALUES (2, 'Lincoln Schelske', '987.654.321-00', 'Rua Almirante Tamandaré, 686', '+5541987987956', TO_DATE('22-12-2018 10:18:02', 'DD-MM-YYYY HH24:MI:SS'), TO_DATE('22-12-2018 10:18:02', 'DD-MM-YYYY HH24:MI:SS'));

INSERT INTO address(id, street, additional_info, latitude, longitude) VALUES (1, 'Av. Cândido de Abreu, 380 - Centro Cívico, Curitiba - PR, 82010-140, Brasil', 'Segundo andar', -25.420959, -49.26916649999998);
INSERT INTO address(id, street, additional_info, latitude, longitude) VALUES (2, 'Av. Cândido Hartmann, 531 - Bigorrilho, Curitiba - PR, 80730-440, Brasil', 'Sala 1308', -25.4309819, -49.2919665);

INSERT INTO point(id, address_id) VALUES (1, 1);
INSERT INTO point(id, address_id) VALUES (2, 2);

INSERT INTO route(id, total_distance, total_due) VALUES (1, 4.32, 17.28);

INSERT INTO route_points(route_id, points_id) VALUES (1, 1);
INSERT INTO route_points(route_id, points_id) VALUES (1, 2);

INSERT INTO customer(id, customer_type, contract_type, stat_cd, cnpj, fantasy_name, social_reason, created_at, updated_at) VALUES (1, 'LEGAL', 'BILLED', 'A', '123.456.789/0001-00', 'Valente Branding', 'Valente Branding ME', TO_DATE('22-12-2018 10:18:02', 'DD-MM-YYYY HH24:MI:SS'), TO_DATE('22-12-2018 10:18:02', 'DD-MM-YYYY HH24:MI:SS'));

INSERT INTO delivery(id, stat_delivery, stat_cd, route_id, customer_id, biker_id, created_at, updated_at) VALUES (1, 'REGISTERED', 'A', 1, 1, 1, TO_DATE('22-12-2018 10:18:02', 'DD-MM-YYYY HH24:MI:SS'), TO_DATE('22-12-2018 10:18:02', 'DD-MM-YYYY HH24:MI:SS'));

