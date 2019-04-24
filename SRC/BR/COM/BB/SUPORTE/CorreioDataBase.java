/**
 * PROJETO DESENVOLVIDO PELA EQUIPE DA MONITORIA - 1903 - CSO BRASILIA F2872117
 * - Elton Macedo Castanho Portela F8369196 - Rafael Shimabukro Borba F8772071
 * Roney Pereira da Costa
 *
 */
package br.com.bb.suporte;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipe Flash Monitoria
 * @date 18/06/2014
 */
public class CorreioDataBase {

    private Table TB_PROCURADORIA;

    public int criaBancoAccess() {
        try {
            String banco = "Banco/BaseCorreioIDA.mdb";

            if (!new File(banco).exists()) {
                new File("Banco").mkdir();
                Database db = DatabaseBuilder.create(Database.FileFormat.V2000, new File("Banco\\BaseCorreioIDA.mdb"));

                TB_PROCURADORIA = new TableBuilder("TB_GERENTE")
                        .addColumn(new ColumnBuilder("CHAVE").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("NOME").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("CARGO").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .toTable(db);

                TB_PROCURADORIA.addRow("F2872117", "Elton Macedo Castanho Portela", "Escriturário");

                TB_PROCURADORIA = new TableBuilder("TB_PROCURADORIA")
                        .addColumn(new ColumnBuilder("UF").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("ENDERECO").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("CEP").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("CIDADE").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("FAX").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("TELEFONE").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("EMAIL").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("PROCURADOR").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("CARGO").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("PROCURADORIA").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .addColumn(new ColumnBuilder("SIGLA").setSQLType(Types.VARCHAR).setMaxLength().toColumn())
                        .toTable(db);

//========================================================================================
//                ATENTAR PARA A TABELA GESTÃO
//========================================================================================
                TB_PROCURADORIA.addRow("AL", "Praça D. Pedro II, nº 16 Centro", "57020-440", "Maceió", "(82) 3221-2145", "(82) 3221 - 8486 / 3311 - 2640 / 2641 / 2642", "pfn.al@pgfn.gov.br", "Elton Gomes Mascarenhas", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DE ALAGOAS", "PFN");
                TB_PROCURADORIA.addRow("AP", "Av. FAB, nº. 427 - Centro", "68900-073", "Macapá", "(96) 3198.2304", "(96) 3198-2300, 3198-2302 e 3198-2328", "pfn.ap@pgfn.gov.br", "Carla Syane Moura Miranda Gama", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO AMAPÁ", "PFN");
                TB_PROCURADORIA.addRow("AM", "Rua Leonardo Malcher nº 1.902 Praça 14 de Janeiro", "69020-070", "Manaus", "(92) 3303-3170", " (92) 3303-3159 / 3303-3150", "pfn.am@pgfn.gov.br", "Tibério Celso Gomes dos Santos", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO AMAZONAS", "PFN");
                TB_PROCURADORIA.addRow("BA", "Rua Araújo Pinho, nº 91 Bairro Canela", "40110-150", "Salvador", "(71) 3338-8675", "(71) 3338-8600", "pfn.ba@pgfn.gov.br", "Marcela Bassi Peres", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DA BAHIA", "PFN");
                TB_PROCURADORIA.addRow("BA", "Dr. Alberto Coimbra, n º 475, 1º andar Sandra Regina", "47802-002", "Barreiras", "(77) 3613-6618", "(77) 3613-6618 / 3612-4716", "", "Mauro Silva Oliveira", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM BARREIRAS", "PSFN");
                TB_PROCURADORIA.addRow("BA", "Av. Getúlio Vargas, Bairro Capuchinhos, Nº 2440", "44076-636", "Feira de Santana", "", " (75) 3626-1597", "", "Luciane Sunao Hamaguchi França", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM FEIRA DE SANTANA", "PSFN");
                TB_PROCURADORIA.addRow("BA", "Rua General Câmara, nº 53 Centro", "45653-220", "Ilhéus", "(73) 3234-3214", "(73) 3234-3200", "psfn.ba.ilheus@pgfn.gov.br", "Caroline Coelho Midlej", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM ILHÉUS", "PSFN");
                TB_PROCURADORIA.addRow("BA", "Rua Pastor Arthur de Souza Freire, nº 750, quadra E Bairro Candeias", "45028-738", "Vitória da Conquista", "(77) 3421-0712", "(77) 3421-0706 e 3421-0712", "psfn.ba.vconquista@pgfn.gov.br", "Flávio Alberto de Melo Araújo", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM VITÓRIA DA CONQUISTA", "PSFN");
                TB_PROCURADORIA.addRow("CE", "Rua Barão de Aracati, 909, 7º Andar Aldeota", "60115-080", "Fortaleza", "(85) 3878-3319", "(85) 3878-3300 - 3323", "pfn.ce@pgfn.gov.br", "Daniel de Saboia Xavier", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO CEARÁ", "PFN");
                TB_PROCURADORIA.addRow("CE", "Rua José Marrocos, nº 1500 Bairro Santa Tereza", "63050-245", "Juzeiro do Norte", "(88) - 3102-6951", "", "apoio.ce.psfn.juazeiro@pgfn.gov.br", "Victor Hugo Reis Pereira", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM JUAZEIRO DO NORTE", "PSFN");
                TB_PROCURADORIA.addRow("DF", "SAUN, Quadra 5, Lote C – 7º Andar Torre D - Centro Empresarial CNC", "70040-250", "Brasília", "", "(61) 2025-4600 /(61) 2025-4602", "", "Cristina Luisa Hedler", "PROCURADORA-REGIONAL", "PROCURADORIA-REGIONAL DA FAZENDA NACIONAL - 1ª REGIÃO", "PRFN");
                TB_PROCURADORIA.addRow("ES", "Rua Pietrângelo de Biase, 56, 5º Andar, sala 506 Centro", "29010-190", "Vitória", "(27) 3211-5166", " (27) 3211-5100", "pfn.es@pgfn.gov.br", "Renato Mendes Souza Santos", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO ESPÍRITO SANTO", "PFN");
                TB_PROCURADORIA.addRow("ES", "Avenida Francisco Lacerda de Aguiar, 16 - 3º e 4º andares Bairro Gilberto Machado", "29303-300", "Cachoeiro de Itapemirim", "", "(28) 3521-1522", "psfn.es.cachoeiro@pgfn.gov.br", "Raphael Silva e Castro", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CAHOEIRO DO ITAPEMERIM", "PSFN");
                TB_PROCURADORIA.addRow("GO", "Av.B (Alfredo de Castro), esquina com a Rua 05, Qd. B-O, Lote 07, Setor Oeste", "74110-030", "Goiânia", "(62) 39014280", "(62) 3901-4240", "pfn.go@pgfn.gov.br", "Adriana Gomes de Paula Rocha", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO GOIÁS", "PFN");
                TB_PROCURADORIA.addRow("GO", "Avenida Pinheiro Chagas com Rua João José,Quadra E, Lotes 17/18, Bairro Jundiaí", "75110-580", "Anápolis", "(62) 3902-1497", "(62) 3902-1495", "", "Renata Branquinho Cardoso da Mota", "PROCURADORA-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM ANÁPOLIS", "PSFN");
                TB_PROCURADORIA.addRow("GO", "Avenida Presidente Vargas, n. 266, Qd. R, Lt. 02, Ed. Centro Empresarial Le Monde, Térreo, Bairro Jardim Marconal", "75901-551", "Rio Verde", "", "(64) 3901-1091", "", "Saulo Paulo de Tarso Sena Lima", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM RIO VERDE", "PSFN");
                TB_PROCURADORIA.addRow("MA", "Rua Oswaldo Cruz nº 1618 - Ed. Sede do Órgãos Fazendários, 7º Andar, Setor C, Centro", "65020-251", "São Luis", "(98) 3231-5806", "(98) 3231-3803 e 3218-7098", "pfn.ma@pgfn.gov.br", "Antonio Leonardo Silva Lindoso", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO MARANHÃO", "PFN");
                TB_PROCURADORIA.addRow("MA", "Rua Godofredo Viana, nº 856, Centro", "65901-480", "Imperatriz", "(99) 3523-3911", "(99) 3525-5528 /3252- 5526", "", "Ylanna Thereza Carvalho Santos Guimarães", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM IMPERATRIZ", "PSFN");
                TB_PROCURADORIA.addRow("MT", "Avenida Vereador Juliano Costa Marques, nº 99 Jardim da Aclimação", "78050-907", "Cuiabá", "(65) 3644-7158", "(65) 3615-2276", "pfn.mt@pgfn.gov.br", "Eliane Moreno Heidgger da Silva", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DE MATO GROSSO", "PFN");
                TB_PROCURADORIA.addRow("MT", "Avenida das Figueiras, 828, 1º piso Centro", "78550-328", "Sinop", "(66) 3532-3643", "(66) 3532-3643 ou 6937", "", "Robert Luiz do Nascimento", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SINOP", "PSFN");
                TB_PROCURADORIA.addRow("MS", "Rua Desembargador Leão Neto do Carmo nº 3 Jardim Veraneio", "79037-902", "Campo Grande", "(67) 3327-0046", "(67)3318-7440 / 7441 / 7442", "pfn.ms@pgfn.gov.br", "Ronilde Langhi Pellin", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DE MATO GROSSO DO SUL", "PFN");
                TB_PROCURADORIA.addRow("MS", "Av. Presidente Vargas, 1600 Vila Progresso", "79825-090", "Dourados", "(67) 3421-6812", "(67) 3421-1042 / 6812 / 8928", "psfn.ms.dourados@pgfn.gov.br", "Helen Maria Ferreira", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM DOURADOS PROCURADOR-SECCIONAL", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Rua Carvalho de Almeida, nº 13, Bairro Cidade Jardim", "30380-160 30380-160", "Belo Horizonte", "(31) 3519-8321", "(31) 3519-8100", "pfn.mg@pgfn.gov.br", "Wagner José Maciel Rollo", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DE MINAS GERAIS", "PFN");
                TB_PROCURADORIA.addRow("MG", "Rua Moacir José Leite, nº 100, 3º Andar, Shopping Pátio Divinópolis Bairro Santa Clara", "35500-119", "Divinópolis", "(37) 3216-7000", "(37) 3216-7000", "psfn.mg.divinopolis@pgfn.gov.br", "Ricardo da Silveira Figueiro", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM DIVINÓPOLIS", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Av. Minas Gerais, 264, Centro", "35010-150", "Governador Valadares", "(33) 3271-1385", "(33) 3279-2900", "psfn.mg.gvaladares@pgfn.gov.br", "Jonatas Vieira de Lima", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM GOVERNADOR VALADARES", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Rua Juiz de Fora, nº 18, Centro", "35160-031", "Ipatinga", "", "(31) 3801-1750", "", "Thaisa Cristina Bernardes Gonçalves", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM IPATINGA", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Avenida Barão do Rio Branco, nº 3428 Centro", "36025-020", "Juiz de Fora", " (32) 3257-2502", "(32) 3257-2400 ou 2534", "psfn.mg.jfora@pgfn.gov.br", "Rildo José de Souza", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM JUIZ DE FORA", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Avenida Deputado Esteves Rodrigues, nº 852 Centro", "39400-215", "Montes Claros", "", "(38) 3690-6200", "psfn.mg.mclaros@pgfn.gov.br", "Eduard Freitas Fernandes", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM MONTES CLAROS", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Avenida Getúlio Vargas, nº 616 Centro", "38700-128", "Patos de Minas", "(34) 3818-9200", "(34) 3825-8436", "", "Luiz Felipe Correa Moreira", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM PATOS DE MINAS", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Rua Pedro Marcondes Duarte, nº 110 Jardim Santa Elisa", "37550-000", "Pouso Alegre", "(35) 3429-7209", "(35) 3429-7200", "apoio.mg.pousoalegre.psfn@pgfn.gov.br", "Rodrigo Gomes de Assis", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM POUSO ALEGRE", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Avenida Dr. Renato Azeredo, 601 Canaan", "35700-312", "Sete Lagoas", "", "(31) 3697-3500 / 3697-3546", "psfn.mg.setelagoas@pgfn.gov.br", "Claudio Roberto Leal Rodrigues", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SETE LAGOAS", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Rua Aluisio de Melo Teixeira, 378 Bairro Fabricio", "38065-290", "Uberaba", "(34) 3331-7200", "(34) 3331-7200 ou 7232", "divida.mg.uberaba.psfn@pgfn.gov.br", "Túlio Faria Tonelli", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM UBERABA", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Praça Tubal Vilela, 41, Centro", "38400-186", "Uberlândia", "(34) 3253-6200", "(34) 3253-6200", "psfn.mg.uberlandia@pgfn.gov.br", "Diego Almeida da Silva", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM UBERLÂNDIA", "PSFN");
                TB_PROCURADORIA.addRow("MG", "Rua Presidente Antônio Carlos, nº 527 Centro", "37002-003 37002-003", "Varginha", "(35) 3690-6711", "(35) 3690-6700", "psfn.mg.varginha@pgfn.gov.br", "Amador Gilberto Cassiano", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM VARGINHA", "PSFN");
                TB_PROCURADORIA.addRow("PA", "Travessa Dom Romualdo de Seixas, nº 651, Umarizal", "66050-110", "Belém", "", "(91) 3212-0424", "", "Aleksey Lanter Cardoso", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO PARÁ", "PFN");
                TB_PROCURADORIA.addRow("PA", "Folha 31, Quadra 8, Lote 7/8, Nova Marabá", "68507-620", "Marabá", "(94) 3322-6299", "(94) 3322-6288 / (94) 3322-6299", "", "Pedro Henrique Ribeiro Gonçalves", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM MARABÁ", "PSFN");
                TB_PROCURADORIA.addRow("PA", "Travessa Silvino Pinto nº.654, Santa Clara", "68005-330", "Santarém", "(93) 3529-2348", "(93) 3523-1032 ou 1488 / 3529-2348 ou 2349", "", "Alfredo Tibúrcio Paiva Frota", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SANTARÉM", "PSFN");
                TB_PROCURADORIA.addRow("PB", "Av. Epitácio Pessoa 1705, 1º Andar - Bairro dos Estados", "58030-001", "João Pessoa", "(81) 3216-4512", "(83) 3216-4480", "pfn.pb@pgfn.gov.br", "César Verzulei Lima Soares de Oliveira", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DA PARAÍBA", "PFN");
                TB_PROCURADORIA.addRow("PB", "Rua Capitão João Alves de Lira, nº 1117 Bairro da Prata,", "58400-560", "Campina Grande", "", "(83) 3341-2239 / 3341-2829 / 3322-3360", "psfn.pb.cgrande@pgn.gov.br", "Luiz Mário Mamede Pinheiro Neto", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CAMPINA GRANDE", "PSFN");
                TB_PROCURADORIA.addRow("PE", "Av. Governador Agamenon Magalhães, 2864, 12º ao 17º Andar Bairro do Espinheiro", "52020-000", "Recife", "", "(81) 3416-5731", "", "Raquel Teresa Martins Peruch Borges", "PROCURADOR-REGIONAL", "PROCURADORIA-REGIONAL DA FAZENDA NACIONAL - 5ª REGIÃO", "PRFN");
                TB_PROCURADORIA.addRow("PE", "Rua Laura  Maciel SANTOS, 23 Maurício de Nassau", "55014-847", "	Caruaru", "(81) 3721-3850", "(81) 3723-6620", "psfn.pe.caruaru@pgfn.gov.br", "Gilberto de Lima Guimarães", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CARUARU", "PSFN");
                TB_PROCURADORIA.addRow("PE", "Rua Valério Pereira, nº 460 Coliseu", "56304-060", "Petrolina", "(87) 3861-0214", "(87) 3861-4454 / 0891", "psfn.pe.petrolina@pgfn.gov.br", "Jovaldo Nunes Gomes Junior", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM PETROLINA", "PSFN");
                TB_PROCURADORIA.addRow("PI", "Edifício Sede do Ministério da Fazenda, 7º andar, Praça Marechal Deodoro, nº 954, Centro", "64000-160", "Teresina", "(86) 3221-6625", "(86) 3221 - 7253 / 3215 - 8010", "pfn.pi@pgfn.gov.br", "Ana Cristina Adad Alencar", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO PIAUÍ", "PFN");
                TB_PROCURADORIA.addRow("RJ", "Av. Presidente Antônio Carlos, nº 375, 7º andar Centro", "20020-010", "Rio de Janeiro", "(21) 3805-2601", "(21) 3805-2600 / 2601 / 2605 / 2606", "prfn2regiao.rj@pgfn.gov.br", "Agostinho do Nascimento Netto", "PROCURADOR-REGIONAL", "PROCURADORIA-REGIONAL DA FAZENDA NACIONAL - 2ª REGIÃO", "PRFN");
                TB_PROCURADORIA.addRow("RJ", "Praça São Salvador, 62, 5º Andar Centro", "28010-000", "Campos dos Goytacazes", "(22) 2722-2114", "(22) 2722-7579 / 5383 / 2733-0593", "psfn.rj.campos@pgfn.gov.br", "Raquel Ribeiro de Carvalho", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CAMPOS DOS GOYTACAZES", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Rua Marechal Deodoro, nº 557, Sobreloja Bairro 25 de Agosto", "25071-190", "Duque de Caxias", "", "(21) 2671-9264", "psfn.rj.duquedecaxias@pgfn.gov.br", "Marcos Pandolfo Fiuza de Melo", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM DUQUE DE CAXIAS", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Rua Promotor Ciro Olimpio da Mata nº 358 Centro", "24800-229", "Itaboraí", "(21) 2635-3847", "(21) 2635-1321 / 3840", "psfn.rj.itaborai@pgfn.gov.br", "Walter Luis Simas Borges", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM ITABORAÍ", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Rua Governador Roberto Silveira nº 10 Centro", "27910-000", "Macaé", "", "(22) 2773-3664 / 2773-3970", "", "Thais Santos Moura Dantas", "PROCURADOR-SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM MACAÉ", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Rua Almirante Teffé, 668, 5º Andar Centro", "24030-085", "Niterói", "(21) 2622-4082", "(21) 2719-5061 / 2694 / 2717-6200", "psfn.rj.niteroi@pgfn.gov.br", "Carlos Roberto Stuart", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM NITERÓI", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Ladeira Robadey, nº 03", "28605-290", "Nova Friburgo", "(22) 2528-5008", "(22) 2528 - 5007 / 5049", "psfn.rj.nfriburgo@pgfn.gov.br", "Nilson de Carvalho Hermida", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM NOVA FRIBURGO", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Rua Ataide Pimenta de Moraes, 220, 5º Andar - Sala 510 Centro", "26210-190", "Nova Iguaçu", "(21) 2667-2931", "(21) 2667-9489 / 9502", "psfn.rj.niguacu@pgfn.gov.br", "Leonardo Martins Pestana", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM NOVA IGUAÇÚ", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Rua Paulo Barbosa, 32 - 4º Andar Centro", "25620-100", "Petrópolis", "(24) 2246-1391", "(24) 2246-1391", "psfn.rj.petropolis@pgfn.gov.br", "Silvio José Fernandes", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM PETRÓPOLIS", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Rua Francisco Villaça, 187 Centro", "27511-280", "Resende", "(24) 3355-4944", "(24) 3355-8020 / 8053 / 4976", "psfn.rj.resende@pgfn.gov.br", "Carlos Fernando de Almeida Dias e Souza", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM RESENDE", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Rua Nossa Senhora Aparecida nº 500, Salas 8 a 11 Parque Central", "28905-190", "Cabo Frio", "(22) 2644-6197", "(22) 2644-6185 / 6137 / 6163", "", "Thiago Cioccari Brigido", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CABO FRIO", "PSFN");
                TB_PROCURADORIA.addRow("RJ", "Rua Lúcio Bittencourt, (Antiga Rua 16) 73, 3º andar Vila Santa Cecília", "27260-110", "Volta Redonda", "(24) 3348-2357", "(24) 3348-2357 / 2321", "psfn.rj.vredonda@pgfn.gov.br", "Claúdio Mota da Silva Barros", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM VOLTA REDONDA", "PSFN");
                TB_PROCURADORIA.addRow("RN", "Rua Anderson Abreu, 3657 Candelária", "59066-100", "Natal", "(84) 3642-6507", "(84) 3642-6514", "pfn.rn@pgfn.gov.br", "Lupércio Camargo Severo de Macedo", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO RIO GRANDE DO NORTE", "PFN");
                TB_PROCURADORIA.addRow("RN", "Av. Alberto Maranhão, nº 1820, Centro", "59600-185", "Mossoró", "", "(84) 3314-9555", "", "Joana Marta Onofre de Araújo", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM MOSSORÓ", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Av. Loureiro da Silva, 445, 9º Andar, Sala 901 Centro Histórico", "90013-900", "Porto Alegre", "", "(51) 3455-2629", "prfn4regiao.rs@pgfn.gov.br", "José Diogo Cyrillo da Silva", "PROCURADOR-CHEFE", "PROCURADORIA-REGIONAL DA FAZENDA NACIONAL - 4ª REGIÃO", "PRFN");
                TB_PROCURADORIA.addRow("RS", "Rua Marcílio Dias 801, 3º andar Centro", "96400-021", "Bagé", "(53) 3242-6510", "(53) 3242-6510 / 3899", "psfn.rs.bage@pgfn.gov.br", "Sabrina dos Santos Velasques", "PROCURADORA SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM BAGÉ", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Av. Planalto, nº 901 São Bento", "95700-000", "Bento Gonçalves", "", "(54) 3451-7828 / 7884", "psfn.rs.bgoncalves@pgfn.gov.br", "Djalma Andrade da Silva Neto", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM BENTO GONÇALVES", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua Quinze de Janeiro, 521, 4º andar Centro", "92010-300", "Canoas", "(51) 3427.5170", "(51) 3427.5170", "psfn.rs.canoas@pgfn.gov.br", "Carlos Augusto Peixoto Reis", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CANOAS", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua Júlio de Castilhos, 150 Nossa Senhora de Lourdes", "95010-000", "Caxias do Sul", "", "(54) 3221-7593", "psfn.rs.caxiasdosul@pgfn.gov.br", "Ederson Couto da Rocha", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CAXIAS DO SUL", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua Irmão Emílio Conrado nº 120 - 5º Andar - Sala 501 Florestal", "95900-000", "Lajeado", "", "(51) 3709-1699", "psfn.rs.lajeado@pgfn.gov.br", "Andres Luiz dos Santos", "PROCURADOR-SECCIONAL", " PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM LAJEADO", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Av. Pedro Adams Filho, nº 5757 Centro", "93310-560", "Novo Hamburgo", "(51) 3593-7679", "(51) 3584-6403 / 6404", "psfn.rs.nhamburgo@pgfn.gov.br", "Francisco Soares Duarte", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM NOVO HAMBURGO", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua Antônio Araújo, Nº 1190 João Lângaro", "99010-220", "Passo Fundo", "(54) 3316-5307", "(54) 3316-5300", "psfn.rs.passofundo@pgfn.gov.br", "Marcos Paulo Sandri", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM PASSO FUNDO", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua XV de Novembro, 667 - Galeria Malcon Centro", "96015-000", "Pelotas", "(53) 3225-8014", "(53) 3227-4863", "psfn.rs.pelotas@pgfn.gov.br", "Pedro Fensterseifer", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM PELOTAS", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua Capitão-Tenente Heitor Perdigão, nº 55", "96200-580", "Rio Grande", "(53) 3231-1400", "(53) 3231-1400", "psfn.rs.riogrande@pgfn.gov.br", "Laura Brandão Chiele", "PROCURADORA SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM RIO GRANDE", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Av. João Pessoa, 260 Centro", "96820-454", "Santa Cruz do Sul", "(51) 3713-2485", "(51) 3715-6472 / 8010", "psfn.rs.stacruzsul@pgfn.gov.br", "Aline Jackisch", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SANTA CRUZ DO SUL", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua Venâncio Aires, 1851 Centro", "97010-003", "Santa Maria", "(55) 3223-6033", "(55) 3219-3341 / 3385", "psfn.rs.stamaria@pgfn.gov.br", "Luís Ricardo Prates de Campos", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SANTA MARIA", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua 7 de Setembro, nº 920", "97573-470", "Santana do Livramento", "(55) 3242-5490", "(55) 3242-5490 / 3241-1679", "psfn.rs.slivramento@pgfn.gov.br", "Paula Gisele Dargelio da Rosa", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SANTANA DO LIVRAMENTO", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua Florência de Abreu, 1660, sala 105 Centro", "98804-560", "Santo Ângelo", "(55) 3312-4899", "(55) 3312-4899 / 6275", "psfn.rs.stoangelo@pgfn.gov.br", "João Aurino de Melo Filho", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SANTO ANGELO", "PSFN");
                TB_PROCURADORIA.addRow("RS", "Rua Bento Martins, 2497 - Sala 902 Centro", "97510-901", "Uruguaiana", "(55) 3412-4103", "(55) 3412-7100 / 3412-7102 / 3412-27104", "psfn.rs.uruguaiana@pgfn.gov.br", "Mauro Moacir Riella Fernandes", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM URUGUAIANA", "PSFN");
                TB_PROCURADORIA.addRow("RO", "Rua 7 de setembro, 1355 Centro", "76801-097", "Porto Velho", "(69) 3901-1024", "(69) 3901- 1000/1004/1005", "pfn.ro@pgfn.gov.br", "Thiago de Faria Lima", "PROCURADORA-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DE RONDÔNIA", "PFN");
                TB_PROCURADORIA.addRow("RR", "Avenida Getúlio Vargas,  nº 4714 São Pedro", "69306-700", "Boa Vista", "(95) 3212-0152", "(95) 3212-0120/ 3212-0144", "pfn.rr@pgfn.gov.br", "Fabíola Manente Lazeris", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DE RORAIMA", "PFN");
                TB_PROCURADORIA.addRow("SC", "Rua Arcipreste Paiva, 107 Centro", "88010-530", "Florianópolis", "", "(48) 3821-2000", "pfn.sc@pgfn.gov.br", "Felipe Dulac Goulart", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DE SANTA CATARINA", "PFN");
                TB_PROCURADORIA.addRow("SC", "Rua XV de Novembro, 1305, 6º andar, Ed. Banco do Brasil Centro", "89010-003", "Blumenau", "(47) 3340-0077", "(47) 3322-8915", "psfn.sc.blumenau@pgfn.gov.br", "Eleandro Ângelo Biondo", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM BLUMENAU", "PSFN");
                TB_PROCURADORIA.addRow("SC", "Rua Sete de Setembro, n. 250-D", "89801-145", "Presidente Médice", "(49) 3322-4433", "", "psfn.sc.chapeco@pgfn.gov.br", "Fábio João Szinwelski", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CHAPECÓ", "PSFN");
                TB_PROCURADORIA.addRow("SC", "Av. Centenário, 3773 - Ed. Executivo Iceberg, 5º andar", "88801-001", "Criciúma", "(48) 3433-1235", "", "apoio.sc.psfn.criciuma@pgfn.gov.br", "Vinícius Garcia", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CRICIÚMA", "PSFN");
                TB_PROCURADORIA.addRow("SC", "Av. Ministro Victor Konder, nº 520, Fazenda", "88301-701", "Itajaí", "", "(47) 3348-2735", "atendimento.sc.itajai.psfn@pgfn.gov.br", "Márcio da Silva Florêncio", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM ITAJAÍ", "PSFN");
                TB_PROCURADORIA.addRow("SC", "Rua Salgado Filho, nº 173 Centro", "89600-000", "Joaçaba", "(49) 3522-3335", "(49) 3522-2289 / 2988", "psfn.sc.joacaba@pgfn.gov.br", "Cristiano Consorte Zapelini", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM JOAÇABA", "PSFN");
                TB_PROCURADORIA.addRow("SC", "Rua Presidente Prudente de Moraes, nº 80 Santo Antônio", "89218-000", "Joinville", "(47) 3422-6908", "(47) 3422-6367", "psfn.sc.joinville@pgfn.gov.br", "Francisco José Tarso de Saboia", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM JOINVILLE", "PSFN");
                TB_PROCURADORIA.addRow("SE", "Rua Francisco Portugal, nº 40 Salgado Filho", "49020-390", "Aracaju", "(79) 3246-1941", "(79) 4009-3200", "pfn.se@pgfn.gov.br", "Paulo Andrade Gomes", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DE SERGIPE", "PFN");
                TB_PROCURADORIA.addRow("TO", "Quadra 202 Norte, Av. LO 4, lotes 05/06, 3º andar, Plano Diretor Norte", "77006-218", "Palmas", "(63) 3901-2204", "(63) 3901-2200 / 2216", "pfn.to@pgfn.gov.br", "Ailton Laboissière Villela", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DE TOCANTINS", "PFN");
                TB_PROCURADORIA.addRow("SP", "Av. Alameda Santos, 647, 15º Andar Cerqueira César", "01419-001", "São Paulo", "(11) 3566-9829", "(11) 3566-9829", "chefiagabinete.sp.prfn3regiao@pgfn.gov.br", "Simone Aparecida Vencigueri Azeredo", "PROCURADOR REGIONAL", "PROCURADORIA-REGIONAL DA FAZENDA NACIONAL - 3ª REGIÃO", "PRFN");
                TB_PROCURADORIA.addRow("SP", "Rua Campos Sales, nº 70 Centro", "16010-230", "Araçatuba", "(18) 2102-2208", "(18) 2102-2200", "psfn.sp.aracatuba@pgfn.gov.br", "Luiz Gustavo de Oliveira Santos", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM ARAÇATUBA", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Avenida Rodrigo Fernando Grillo, n° 2775", "14801-534", "Jardim dos Manacás", "(16) 3331-2485", "(16) 2108-1950", "psfn.sp.araraquara@pgfn.gov.br", "Carlos Eduardo de Freitas Fazoli", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM ARARAQUARA", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Rua Rio Branco, nº 18-39 Vila América", "17014-037", "Bauru", "(14) 2106-2797", "(14) 2106-2750 / 2785", "psfn.sp.bauru@pgfn.gov.br", "Cristiane de Barros Santos", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM BAURU", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Rua Frei Antonio de Pádua, nº 1.595 Jardim Guanabara", "13073-330", "Campinas", "(19) 2101-9260", "(19) 2101-9255", "psfn.sp.campinas@pgfn.gov.br", "Sérgio Montifeltro Fernandes", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM CAMPINAS", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Av. Frei Germano nº 2300 - Estação Franca", "14405-215", "Franca", "(16) 3012-8137", "(16) 3012-8100", "", "Laís Cláudia de Lima", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM FRANCA", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Rua Luiz Turri nº 44, Jardim Zaira", "07095-060", "Guarulhos", "(11) 2131-6874", "(11) 2131-6888 / 2131-6868", "psfn.sp.guarulhos@pgfn.gov.br", "Guilherme Chagas Monteiro", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM GUARULHOS", "PSF");
                TB_PROCURADORIA.addRow("SP", "Rua Dr. Torres Neves, 508 Centro", "13201-058", "Jundiaí", "(11) 2448-9084", "(11) 2448-9050", "psfn.sp.jundiai@pgfn.gov.br", "Mayre Komuro", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM JUNDIAÍ", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Av. Sampaio Vidal, 779/789, 6º andar Centro", "17500-021", "Marília", "(14) 2105-5555", "(14) 2105-5550", "psfn.sp.marilia@pgfn.gov.br", "Luciano José de Brito", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM MARILIA", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Rua Olegário Paiva, 56", "08780-040", "Mogi das Cruzes", "", "(11) 2927-2800", "psfn.sp.mogi@pgfn.gov.br", "Igor dos Reis Ferreira", "PROCURADORES SECCIONAL SUBSTITUTOS", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM MOGI DAS CRUZES", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Av. Padre Vicente Melillo, 755 Vila Clélia", "06036-013", "Osasco", "(11) 2131-6994", "(11) 2131-6951", "psfn.sp.osasco@pgfn.gov.br", "Luciane Hiromi Tominaga", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM OSASCO", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Rua São José, 844 Centro", "13400-330", "Piracicaba", "(19) 2105-2330", "(19) 2105-2300", "psfn.sp.piracicaba@pgfn.gov.br", "Lorena de Castro Costa", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM PIRACICABA", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Rua Dr. José Foz, 323 Centro", "19010-041", "Presidente Prudente", "(18) 2101-5751", "(18) 2101-5777", "psfn.sp.pprudente@pgfn.gov.br", "Leonardo Rufino de Oliveira Gomes", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM PRESIDENTE PRUDENTE", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Av. Professor João Fiusa,  nº 2.440 Jardim Canadá", "14024-260", "Ribeirão Preto", "(16) 2111-2305", "(16) 2111-2333 e 2111-2300", "", "Mário Augusto Carboni", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM RIBEIRÃO PRETO", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Rua Primeiro de Maio, 178,Centro", "09015-030", "Santo André", "(11) 2131-5762", "(11) 2131-5777 / 5750", "", "Vanessa Scarpa Mota", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SANTO ANDRÉ", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Praça da República, 22/25 Centro", "11013-010", "Santos", "(13) 2102-5402", "(13) 2102-5400 / (13) 2102-5444", "psfn.sp.santos@pgfn.gov.br", "Bruno Nascimento Amorim", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SANTOS", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Av. Kennedy, nº 88 Jd. Do Mar", "09726-250", "São Bernardo do Campo", "(11) 3535.8053", "(11) 3535.8050/8053", "psfn.sp.sbernardo@pgfn.gov.br", "Yuri José de Santana Furtado", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SÃO BERNARDO DO CAMPO", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Rua Conde do Pinhal, 2185 Centro", "13560-648", "São Carlos", "(16) 3412-2701", "(16) 3412-2700", "psfn.sp.saocarlos@pgfn.gov.br", "Dacier Martins de Almeida", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SÃO CARLOS", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Av. Dr. Cenobelino Barros Serra 1600 Parque Industrial", "15030-000", "São José do Rio Preto", "(17) 2136-6554", "(17) 2136-6555 / 6554", "psfn.sp.sjriopreto@pgfn.gov.br", "Lívia Joyce Cavalhieri da Cruz Paula", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SÃO JOSÉ DO RIO PRETO", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Rua XV de Novembro, 337 Centro", "12210-070", "São José dos Campos", "(12) 2136-9862", "(12) 2136-9888", "psfn.sp.sjcampos@pgfn.gov.br", "Marcelo Carneiro Vieira", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SÃO JOSÉ DOS CAMPOS", "PSFN");
                TB_PROCURADORIA.addRow("SP", "Av. General Osório, 986 Trujillo", "18060-502", "Sorocaba", "(15) 2102-4954", "(15) 2102-4999", "psfn.sp.sorocaba@pgfn.gov.br", "Reiner Zenthofer Muller", "PROCURADOR SECCIONAL SUBSTITUTO", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM SOROCABA", "PSFN/SOROC");
                TB_PROCURADORIA.addRow("SP", "Rua Claro Gomes, 129 Bairro Santa Luzia", "12010-520", "Taubaté", "(12) 3622.7600", "(12) 2123.2123 e 3622.7600", "psfn.sp.taubate@pgfn.gov.br", "Cristiano Gomes da Silva Paladino", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM TAUBATÉ", "PSFN");
                TB_PROCURADORIA.addRow("SC", "Rua Coronel Córdova, 423 Centro", "88502-902", "Lages", " (49) 3224-1989", "", "psfn.sc.lages@pgfn.gov.br", "Daniel Oliveira Teles de Menezes", "PROCURADOR SECCIONAL", "PROCURADORIA SECCIONAL DA FAZENDA NACIONAL EM LAGES", "PSFN");
                TB_PROCURADORIA.addRow("AC", "Rua Marechal Deodoro, nº 340, 6º andar Centro", "69900-903", "Rio Branco", "(68) 3224-5380", "3223 8138", "pfn.ac@pgfn.gov.br", "Rubem César Costa Guerra", "PROCURADOR-CHEFE", "PROCURADORIA DA FAZENDA NACIONAL NO ESTADO DO ACRE", "PFN");

                System.out.println("Banco de dados Criado!");
                return 1;
            } else {
                System.out.println("Banco de dados já existe");
                return 0;
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean apagarTabela(String nomeTabela) {
        try {
            Table table = DatabaseBuilder.open(new File("Banco\\BaseCorreioIDA.mdb")).getTable(nomeTabela);
            for (Row row : table) {
                table.deleteRow(row);
            }
            System.out.println("TABELA " + nomeTabela + " APAGADA");
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void corrigirBanco() {
        try {
            String banco = "Banco/BaseCorreioIDA.mdb";
            CorreioDataBase contrato = new CorreioDataBase();
            if (new File(banco).exists()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy - hh_mm_ss");
                File arquivoTemporario = new File("Banco/BaseCorreioIDA.mdb");
                File arquivoNovo = new File("Banco/BaseCorreioIDA-BKP-" + dateFormat.format(new Date()).replaceAll("\\.", "").replaceAll("/", "").replaceAll(":", "") + ".mdb");
                System.out.println(">-" + arquivoTemporario.renameTo(arquivoNovo));
                contrato.criaBancoAccess();

            } else {
                contrato.criaBancoAccess();
            }
            JOptionPane.showMessageDialog(null, "Banco restaurado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar o Banco\n Realizar o procedimento manualmente");
        }
    }

}
