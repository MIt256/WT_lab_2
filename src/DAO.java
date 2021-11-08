import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.*;

/**
 * Class for a data access object.
 * @author  Zanko Maksim
 * @version  1.0
 */
public class DAO implements DAOInterface {
    /**
     * Method for output list of  all products from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    @Override
    public void printAllProducts(Document document) throws XPathExpressionException {
        System.out.print("ALL PRODUCTS:");

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expression = xPath.compile("/products");

        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.print(node.getTextContent());
        }
    }

    /**
     * Method for output only kettles from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    @Override
    public void printOnlyKettles(Document document) throws XPathExpressionException {
        System.out.print("ALL KETTLES:");

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expression = xPath.compile("//product[info/@type='kettle']");

        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.print(node.getTextContent());
        }
        System.out.println();
    }

    /**
     * Method for output product with minimal cost from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    @Override
    public void printProductsWithMinimalCost(Document document) throws XPathExpressionException {
        System.out.print("PRODUCT WITH MIN COST:");

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expr = xPath.compile("//product[not(price > //product/price)]");

        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.print(node.getTextContent());
        }
    }
}
