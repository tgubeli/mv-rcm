package cl.masvida.poc.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import com.redhat.masvida.vo.AgenciaVO;
import com.redhat.masvida.vo.RcmVO;
import com.redhat.masvida.vo.TipoPagoVO;

@Remote
public interface RCMFacade {

	public RcmVO buscarRcm(BigDecimal i);
	public List<AgenciaVO> buscarAgencias();
	public List<TipoPagoVO> buscarTipoPagos();
}
