import org.w3c.dom.Document;
import javax.xml.xpath.XPathExpressionException;

/**
 * Interface
 * @version 1.0
 * @author Zanko Maksim
 */
public interface DAOInterface {
    /**
     * Method for output list of products from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    void printAllProducts(Document document) throws XPathExpressionException;
    /**
     * Method for output kettles from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    void printOnlyKettles(Document document) throws XPathExpressionException;
    /**
     * Method for output product with minimal cost from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    void printProductsWithMinimalCost(Document document) throws XPathExpressionException;
}
