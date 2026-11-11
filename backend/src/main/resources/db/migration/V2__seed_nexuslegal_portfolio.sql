INSERT INTO organizations(name,type) VALUES ('Nexus Office','LAW_ACCOUNTING'),('Alfa Engenharia S.A.','COMPANY'),('Beta Foods Ltda.','COMPANY'),('Gamma Logística S.A.','COMPANY'),('Delta Saúde Integrada','COMPANY');
INSERT INTO users(username,full_name,email,role) VALUES ('partner','Marina Albuquerque','marina@nexusoffice.local','PARTNER'),('lawyer','Rafael Mendes','rafael@nexusoffice.local','LAWYER'),('accountant','Camila Freitas','camila@nexusoffice.local','ACCOUNTANT'),('assistant','João Viana','joao@nexusoffice.local','ASSISTANT'),('alfa_admin','Fernanda Lima','fernanda@alfa.local','CLIENT_ADMIN'),('beta_viewer','Gustavo Reis','gustavo@beta.local','CLIENT_VIEWER'),('auditor','Luciana Prado','luciana@nexusoffice.local','AUDITOR');
INSERT INTO memberships(user_id,organization_id,role) SELECT u.id,1,u.role FROM users u WHERE u.username IN ('partner','lawyer','accountant','assistant','auditor');
INSERT INTO memberships(user_id,organization_id,role) SELECT u.id,2,'CLIENT_ADMIN' FROM users u WHERE u.username='alfa_admin';
INSERT INTO memberships(user_id,organization_id,role) SELECT u.id,3,'CLIENT_VIEWER' FROM users u WHERE u.username='beta_viewer';
INSERT INTO companies(organization_id,legal_name,tax_id,segment,status,annual_revenue) VALUES
 (1,'Alfa Engenharia S.A.','12.345.678/0001-90','Construção','ACTIVE',18500000),
 (1,'Beta Foods Ltda.','23.456.789/0001-12','Alimentos','ACTIVE',9200000),
 (1,'Gamma Logística S.A.','34.567.890/0001-34','Transportes','ACTIVE',27600000),
 (1,'Delta Saúde Integrada','45.678.901/0001-56','Saúde','ACTIVE',11300000);
INSERT INTO individual_clients(organization_id,full_name,document,email) VALUES (1,'Patrícia Soares','111.222.333-44','patricia@cliente.local'),(1,'Eduardo Nunes','222.333.444-55','eduardo@cliente.local'),(1,'Roberta Azevedo','333.444.555-66','roberta@cliente.local');
INSERT INTO matters(organization_id,client_type,client_id,title,area,status,priority,responsible_user_id,next_deadline,value) VALUES
 (1,'COMPANY',1,'Revisão de contrato de fornecimento','Contratos','IN_REVIEW','HIGH',2,'2026-12-04',450000),
 (1,'COMPANY',2,'Adequação tributária do exercício','Tributário','ACTIVE','MEDIUM',3,'2026-12-12',180000),
 (1,'COMPANY',3,'Ação trabalhista 004821','Trabalhista','HEARING','HIGH',2,'2026-11-28',750000),
 (1,'COMPANY',4,'Governança e proteção de dados','Empresarial','ACTIVE','LOW',1,'2027-01-15',95000),
 (1,'INDIVIDUAL',1,'Inventário e planejamento patrimonial','Cível','ACTIVE','MEDIUM',2,'2026-12-20',120000),
 (1,'INDIVIDUAL',2,'Defesa em cobrança contratual','Cível','PENDING','HIGH',2,'2026-11-30',60000);
INSERT INTO obligations(organization_id,company_id,title,obligation_type,due_date,status,amount,responsible_user_id) VALUES
 (1,1,'ECD - Escrituração Contábil Digital','Contábil','2026-11-30','PENDING',0,3),(1,1,'DCTF mensal','Fiscal','2026-12-15','IN_PROGRESS',0,3),(1,2,'EFD Contribuições','Fiscal','2026-12-10','PENDING',0,3),(1,2,'Folha de pagamento','Departamento Pessoal','2026-11-25','REVIEW',325000,3),(1,3,'Apuração ICMS','Fiscal','2026-12-05','PENDING',0,3),(1,3,'Relatório de riscos trabalhistas','Jurídico','2026-11-22','IN_PROGRESS',0,2),(1,4,'LGPD - revisão de contratos','Compliance','2027-01-10','PENDING',0,2),(1,4,'Balancete mensal','Contábil','2026-11-30','DONE',0,3);
INSERT INTO documents(organization_id,matter_id,company_id,title,category,content,owner_user_id) VALUES
 (1,1,1,'Contrato de fornecimento - versão 4','Contrato','Minuta consolidada para revisão da diretoria.',2),(1,1,1,'Procuração empresarial','Procuração','Instrumento de representação com poderes específicos.',1),(1,2,2,'Balancete outubro 2026','Contábil','Receitas operacionais e composição de tributos.',3),(1,3,3,'Defesa trabalhista inicial','Processual','Peça de defesa e documentos de suporte.',2),(1,4,4,'Mapa de dados pessoais','Compliance','Inventário de tratamentos e bases legais.',1),(1,5,NULL,'Declaração patrimonial','Patrimonial','Documentos pessoais de planejamento sucessório.',2),(1,6,NULL,'Comprovantes do contrato','Probatório','Conjunto de comprovantes e comunicações.',2);
INSERT INTO tasks(organization_id,title,due_date,status,priority,assigned_user_id) VALUES
 (1,'Revisar cláusulas de responsabilidade','2026-11-22','OPEN','HIGH',2),(1,'Conferir notas fiscais da Alfa','2026-11-24','IN_PROGRESS','MEDIUM',3),(1,'Preparar reunião com diretoria Beta','2026-11-26','OPEN','MEDIUM',1),(1,'Subir relatório de riscos','2026-11-20','OVERDUE','HIGH',4),(1,'Validar procurações','2026-12-01','OPEN','LOW',2),(1,'Fechar folha mensal','2026-11-25','IN_PROGRESS','HIGH',3);
INSERT INTO audit_events(organization_id,actor_user_id,action,resource,details) VALUES
 (1,1,'LOGIN','session','Login efetuado a partir do painel principal'),(1,2,'DOCUMENT_VIEW','document:1','Documento de contrato consultado'),(1,3,'OBLIGATION_UPDATE','obligation:2','Status alterado para em andamento'),(1,1,'MATTER_ASSIGN','matter:3','Responsabilidade atribuída ao jurídico'),(1,7,'AUDIT_EXPORT','portfolio','Relatório de acessos gerado');
