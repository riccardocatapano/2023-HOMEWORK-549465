package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {

	private String attrezzoSbloccante;
	private String direzioneBloccata;

	public StanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		super(nome);
		this.attrezzoSbloccante = attrezzoSbloccante;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.direzioneBloccata) && !super.hasAttrezzo(attrezzoSbloccante))
			return this;
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(attrezzoSbloccante)) {
			return super.getDescrizione();	
		}
		else {
			StringBuilder nuovaDescrizione = new StringBuilder();
			nuovaDescrizione.append(super.getNome());
			nuovaDescrizione.append("\nUscite: ");
			for (String direzione : super.getDirezioni())
				if (direzione!=null) {
					if(direzione.equals(direzioneBloccata)) {
						nuovaDescrizione.append(" "+ direzione +"bloccata, usa "+ this.attrezzoSbloccante +" ");
					}
					else {
						nuovaDescrizione.append(" " + direzione);
					}
				}
				nuovaDescrizione.append("\nAttrezzi nella stanza: ");
				for (Attrezzo attrezzo : super.getAttrezzi()) {
					if (attrezzo != null)
						nuovaDescrizione.append(attrezzo.toString()+" ");
					}
				return nuovaDescrizione.toString();	
		}
	}

}