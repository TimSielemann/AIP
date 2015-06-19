package de.ants.aip.rating.graph.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.annotation.ResultColumn;
import org.springframework.data.neo4j.repository.GraphRepository;

import de.ants.aip.rating.dto.SalesData;
import de.ants.aip.rating.graph.nodes.AuftragsPositionRelation;
import de.ants.aip.rating.graph.nodes.ProduktNode;
import de.ants.aip.rating.graph.repository.KundeGraphRepository.SalesDataImpl;

public interface ProduktGraphRepository extends GraphRepository<ProduktNode> {

	ProduktNode findByDbid(Long id);
	
	
	@Query("MATCH (produkt:ProduktNode{produktName:{0}}), produkt<-[bestellung:"+AuftragsPositionRelation.RELATIONSHIP_TYPE+"]->(kunde)<-[bestellungB:"+AuftragsPositionRelation.RELATIONSHIP_TYPE+"]->(produktb) RETURN produktb")
	Iterable<ProduktNode> showProductsBuyed(String produktname);
	
	@QueryResult
	public class SalesDataImpl implements SalesData {
		@ResultColumn("produktb")
		private ProduktNode produkt;

		public ProduktNode getProdukt() {
			return produkt;
		}

		public void setProdukt(ProduktNode produkt) {
			this.produkt = produkt;
		}

		@Override
		public String toString() {
			return "SalesData [produkt=" + getProdukt() + "]";
		}

		@Override
		public Integer getCount() {
			return 0;
		}
		
		
	}
}