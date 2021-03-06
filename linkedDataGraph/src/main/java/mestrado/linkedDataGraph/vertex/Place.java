package mestrado.linkedDataGraph.vertex;

import mestrado.linkedDataGraph.edge.Place2NPlaceRel;

import com.thinkaurelius.titan.core.attribute.Geoshape;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Incidence;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.annotations.gremlin.GremlinGroovy;
import com.tinkerpop.frames.annotations.gremlin.GremlinParam;

public interface Place extends Entity {

	@Adjacency(label = "containedBy", direction = Direction.OUT)
	public void addContainedBy(Place place);
	@Adjacency(label = "containedBy", direction = Direction.IN)
	public void addContains(Place place);

	@Adjacency(label = "country", direction = Direction.OUT)
	public void addCountry(Place place);
	@Incidence(label = "related")
	public Place2NPlaceRel addRelatedEntity(NonPlace entity);
	
	@GremlinGroovy("it.as('x').in('isName').out('isName').except('x').has('dbpediaId').hasNot('geonamesId')")
    public Iterable<Place> getAmbiguosDbPediaPlaces();

	@GremlinGroovy(value="it.outE('related').has('predicate', predicate).inV().has('freebaseId', nonplaceId).hasNext()", frame=false)
	public Boolean isRelatedWithNonPLace(@GremlinParam("predicate") String predicate, @GremlinParam("nonplaceId") String nonplaceId);
	
	@Adjacency(label = "containedBy", direction = Direction.OUT)
	public Iterable<Place> getContainedBy();
	
	@Adjacency(label = "containedBy", direction = Direction.IN)
	public Iterable<Place> getContains();
	@Adjacency(label = "country", direction = Direction.OUT)
	public Iterable<Place> getCountries();

	@Adjacency(label = "related", direction = Direction.OUT)
	public Iterable<NonPlace> getRelatedNonPlaces();

	@Property("dbpPoint") 
	public Geoshape getDBPediaPoint();

	@Property("setdel")
	public Boolean getDelete();
	
	@Property("frbPoint") 
	public Geoshape getFreebasePoint();
	
	@Property("gnFeatureClass")
	public Character getGeonamesFeatureClass();
	
	@Property("gnFeatureCode")
	public String getGeonamesFeatureCode();
	
	@Property("geonamesId")
	public String getGeonamesId();

	@Property("lgdId")
	public String getLinkedGeoDataId();

	@Property("lgdId")
	public void setLinkedGeoDataId(String lgdId);
	
	@Property("gnPoint") 
	public Geoshape getGeonamesPoint();

	@Property("lgdPoint") 
	public Geoshape getLinkedGeoDataPoint();

	@Property("ontogztId")
	public String getOntogztId();
	
	@Incidence(label = "related")
	public Iterable<Place2NPlaceRel> getRelatedNonPlaceEdges();

	@Property("dbpPoint") 
	public void setDBPediaPoint(Geoshape point);

	@Property("setdel")
	public void setDelete(Boolean delete);
	
	@Property("frbPoint") 
	public void setFreebasePoint(Geoshape point);
	
	@Property("gnFeatureClass")
	public void setGeonamesFeatureClass(Character featureClass);
	
	@Property("gnFeatureCode")
	public void setGeonamesFeatureCode(String featureCode);
	
	@Property("geonamesId")
	public void setGeonamesId(String geonamesId);

	@Property("gnPoint") 
	public void setGeonamesPoint(Geoshape point);

	@Property("lgdPoint") 
	public void setLinkedGeoDataPoint(Geoshape point);
	
	@Property("ontogztId")	
	public void setOntogztId(String ontogazId);
	
}
