
/**
 * Classe stockant un résultat de recherche
 * @author nikkidbz
 */
public class Result implements Comparable<Result>{
	
	/**
	 * Nom du fichier résulat
	 * @var m_filePath
	 */
	private String m_filePath ;
	
	/**
	 * Balise résultat. Facultatif - par défaut : "/article[1]"
	 * @var m_tag
	 */
	private String m_tag = "/article[1]";
	
	/**
	 * Requête pour laquelle est calculé le résultat.
	 * Champ facultatif pour l'écriture si les reqêtes sont faîte une à une
	 * @var m_query
	 */
	private Query m_query = null ;
	
	/**
	 * Rang du résultat pour la requête
	 * Champ facultatif pour l'écriture si le tableau de résulats est trié
	 * @var m_rank
	 */
	private int m_rank = -1 ;
	
	/**
	 * Poid du résultat pour la requête
	 * Champ facultatif pour l'écriture si le tableau de résulats est trié
	 * @var m_weight
	 */
	private double m_weight = 0 ;
	
	/**
	 * Indique si le poid doit être utilisé
	 * @var m_weightToConsider
	 */
	private boolean m_weightToConsider = false ;
	
	
	
	
	public Result( String filePath ) {
		m_filePath = filePath ;
	}
	
	public Result( String filePath, String tag ) {
		m_filePath = filePath ;
		m_tag = tag ;
	}

	/**
	 * Récupère le nom du fichier (sans le chemin ni l'extension)
	 * @return the m_filePath
	 */
	public String getFileName() {
		
		int lastSlash = m_filePath.lastIndexOf( "/" ) ;
		int lastpoint = m_filePath.lastIndexOf( "." ) ;
		
		String fileName ;
		if( lastpoint == -1 )
			fileName = m_filePath.substring(lastSlash +1);	
		else
			fileName = m_filePath.substring(lastSlash +1, lastpoint);
		
		return fileName ;
	}
	
	
	
	/**
	 * @return the m_filePath
	 */
	public String getFilePath() {
		return m_filePath;
	}


	/**
	 * @param m_filePath the m_filePath to set
	 */
	public void setFilePath(String m_filePath) {
		this.m_filePath = m_filePath;
	}


	/**
	 * @return the m_tag
	 */
	public String getTag() {
		return m_tag;
	}


	/**
	 * @param m_tag the m_tag to set
	 */
	public void setTag(String m_tag) {
		this.m_tag = m_tag;
	}


	/**
	 * @return the m_query
	 */
	public Query getQuery() {
		return m_query;
	}


	/**
	 * @param m_query the m_query to set
	 */
	public void setQuery(Query m_query) {
		this.m_query = m_query;
	}


	/**
	 * @return the m_rank
	 */
	public int getRank() {
		return m_rank;
	}


	/**
	 * @param m_rank the m_rank to set
	 */
	public void setRank(int m_rank) {
		this.m_rank = m_rank;
	}


	/**
	 * @return the m_weight
	 */
	public double getWeight() {
		return m_weight;
	}


	/**
	 * @param m_weight the m_weight to set
	 */
	public void setWeight(double m_weight) {
		this.m_weight = m_weight;
	}
	
	/**
	 * @param m_weight the m_weight to add
	 */
	public void addWeight(double weight) {
		m_weight += weight;
	}


	/**
	 * @return the m_weightToConsider
	 */
	public boolean isWeightToConsider() {
		return m_weightToConsider;
	}
	
	
	public int compareTo(Result r ) {
		if( r.getWeight() > m_weight )
			return 1 ;
		else if ( r.getWeight() < m_weight )
			return -1 ;
	
		return 0 ;
	}

	/**
	 * @param m_weightToConsider the m_weightToConsider to set
	 */
	public void setWeightToConsider(boolean m_weightToConsider) {
		this.m_weightToConsider = m_weightToConsider;
	}
	
}
