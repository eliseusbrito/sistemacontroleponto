package com.eliseubrito.sistemacontrole.config;

import com.eliseubrito.sistemacontrole.model.*;
import com.eliseubrito.sistemacontrole.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class DadosIniciais implements CommandLineRunner {

    @Autowired
    private JornadaRepository jornadaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private TipoDataRepository tipoDataRepository;

    @Autowired
    private CalendarioRepository calendarioRepository;

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private BancoHorasRepository bancoHorasRepository;

    @Override
    public void run(String... args) throws Exception {
        JornadaTrabalho jt1 = new JornadaTrabalho(1, "CNPJ");
        JornadaTrabalho jt2 = new JornadaTrabalho(2, "PJ");
        jornadaRepository.saveAll(Arrays.asList(jt1,jt2));

        Empresa e1 = new Empresa(1L,"Empresa One","897984", "Rua dos Sonhos", "Bairro dos Amores", "Cidade dos Horrores", "TH", "35654655" );
        Empresa e2 = new Empresa(2L,"Empresa Two","897985", "Rua dos Sonhos", "Bairro dos Amores", "Cidade dos Horrores", "TH", "35654656" );
        empresaRepository.saveAll(Arrays.asList(e1,e2));

        CategoriaUsuario cu1 = new CategoriaUsuario(1,"Categoria Usuario One");
        CategoriaUsuario cu2 = new CategoriaUsuario(2,"Categoria Usuario Two");
        categoriaUsuarioRepository.saveAll(Arrays.asList(cu1,cu2));

        NivelAcesso na1 = new NivelAcesso(1,"Nivel Acesso One");
        NivelAcesso na2 = new NivelAcesso(2,"NivelAcesso Two");
        nivelAcessoRepository.saveAll(Arrays.asList(na1,na2));

        Ocorrencia o1 = new Ocorrencia(1,"Nome Ocorrencia One","Descrição Ocorrencia One");
        Ocorrencia o2 = new Ocorrencia(2,"Nome Ocorrencia Two", "Descrição Ocorrencia Two");
        ocorrenciaRepository.saveAll(Arrays.asList(o1,o2));

        TipoData td1 = new TipoData(1,"TipoData One");
        TipoData td2 = new TipoData(2,"TipoData Two");
        tipoDataRepository.saveAll(Arrays.asList(td1,td2));

        Calendario c1 = new Calendario(1L,td1, "Calendario One", LocalDateTime.now());
        Calendario c2 = new Calendario(2L,td2, "Calendario Two", LocalDateTime.of(2019, 03, 28, 14, 33, 48, 123456789));
        calendarioRepository.saveAll(Arrays.asList(c1,c2));

        Localidade l1 = new Localidade(1,na1,"Localidade One");
        Localidade l2 = new Localidade(2,na2,"Localidade Two");
        localidadeRepository.saveAll(Arrays.asList(l1,l2));

        BigDecimal bd = new BigDecimal(5.76);
        LocalDateTime inicioJornada = LocalDateTime.of(2019, 03, 28, 8, 0, 0,00);
        LocalDateTime finalJornada = LocalDateTime.of(2019, 03, 28, 17,0);
        Usuario u1 = new Usuario(1L, cu1, "Eliseu", e1, na1, jt1, bd, inicioJornada, finalJornada);
        Usuario u2 = new Usuario(2L, cu2, "João", e2, na2, jt2, bd, inicioJornada, finalJornada);
        usuarioRepository.saveAll(Arrays.asList(u1,u2));

        Movimentacao.MovimentacaoId mi1 = new Movimentacao.MovimentacaoId(1L,1L);

        LocalDateTime dataEntrada = LocalDateTime.of(2019, 03, 28, 8, 0, 0,00);
        LocalDateTime dataSaida = LocalDateTime.of(2019, 03, 28, 17,0);
        Movimentacao m1 = new Movimentacao(mi1,dataEntrada,dataSaida, bd,o1, c1);
        movimentacaoRepository.saveAll(Arrays.asList(m1));

        BancoHoras.BancoHorasId bhi1 = new BancoHoras.BancoHorasId(1L,1L,1L);

        BigDecimal qh = new BigDecimal(8.06);
        BigDecimal sh = new BigDecimal(1.3);
        LocalDateTime dataTrabalhada = LocalDateTime.of(2019, 03, 28, 17,0);
        BancoHoras bh1 = new BancoHoras(bhi1,dataTrabalhada,qh,sh);
        bancoHorasRepository.saveAll(Arrays.asList(bh1));

    }

}
