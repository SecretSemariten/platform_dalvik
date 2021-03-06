/*
 This Java source file was generated by test-to-java.xsl
 and is a derived work from the source document.
 The source document contained the following notice:



 Copyright (c) 2001 World Wide Web Consortium, 
 (Massachusetts Institute of Technology, Institut National de
 Recherche en Informatique et en Automatique, Keio University).  All 
 Rights Reserved.  This program is distributed under the W3C's Software
 Intellectual Property License.  This program is distributed in the 
 hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
 PURPOSE.  

 See W3C License http://www.w3.org/Consortium/Legal/ for more details.


 */

package tests.org.w3c.dom;

import dalvik.annotation.TestTargets;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestTargetClass;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;

import javax.xml.parsers.DocumentBuilder;

/**
 * The method hasAttributes returns whether this node (if it is an element) has
 * any attributes. Retreive an element node without attributes. Verify if
 * hasAttributes returns false. Retreive another element node with attributes.
 * Verify if hasAttributes returns true.
 * 
 * @author IBM
 * @author Neil Delima
 * @see <a
 *      href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeHasAttrs</a>
 */
@TestTargetClass(Node.class) 
public final class NodeHasAttributes extends DOMTestCase {

    DOMDocumentBuilderFactory factory;

    DocumentBuilder builder;

    protected void setUp() throws Exception {
        super.setUp();
        try {
            factory = new DOMDocumentBuilderFactory(DOMDocumentBuilderFactory
                    .getConfiguration1());
            builder = factory.getBuilder();
        } catch (Exception e) {
            fail("Unexpected exception" + e.getMessage());
        }
    }

    protected void tearDown() throws Exception {
        factory = null;
        builder = null;
        super.tearDown();
    }

    /**
     * Runs the test case.
     * 
     * @throws Throwable
     *             Any uncaught exception causes test to fail
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "hasAttributes",
        args = {}
    )
    public void testHasAttributes1() throws Throwable {
        Document doc;
        Element element;
        NodeList elementList;
        boolean hasAttributes;
        doc = (Document) load("staff", builder);
        elementList = doc.getElementsByTagName("employee");
        element = (Element) elementList.item(0);
        hasAttributes = element.hasAttributes();
        assertFalse("nodehasattributes01_1", hasAttributes);
        elementList = doc.getElementsByTagName("address");
        element = (Element) elementList.item(0);
        hasAttributes = element.hasAttributes();
        assertTrue("nodehasattributes01_2", hasAttributes);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL,
        notes = "Verifies that hasAttributes method returns false value.",
        method = "hasAttributes",
        args = {}
    )
    public void testHasAttributes2() throws Throwable {
        Document doc;
        DocumentType docType;
        boolean hasAttributes;
        doc = (Document) load("staffNS", builder);
        docType = doc.getDoctype();
        hasAttributes = docType.hasAttributes();
        assertFalse("nodehasattributes02", hasAttributes);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL,
        notes = "Verifies that hasAttributes method returns true value.",
        method = "hasAttributes",
        args = {}
    )
    public void testHasAttributes3() throws Throwable {
        Document doc;
        Element element;
        NodeList elementList;
        boolean hasAttributes;
        doc = (Document) load("staffNS", builder);
        elementList = doc.getElementsByTagName("emp:employee");
        element = (Element) elementList.item(0);
        assertNotNull("empEmployeeNotNull", element);
        hasAttributes = element.hasAttributes();
        assertTrue("hasAttributes", hasAttributes);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL,
        notes = "Verifies that hasAttributes method returns true value.",
        method = "hasAttributes",
        args = {}
    )
    public void testHasAttributes4() throws Throwable {
        Document doc;
        Document newDoc;
        DocumentType docType = null;

        DOMImplementation domImpl;
        Element element;
        Element elementTest;
        Element elementDoc;
        Attr attribute;
        
        
        NodeList elementList;
        boolean hasAttributes;
        doc = (Document) load("staffNS", builder);
        domImpl = doc.getImplementation();
        newDoc = domImpl.createDocument("http://www.w3.org/DOM/Test", "test",
                docType);
        element = newDoc.createElementNS("http://www.w3.org/DOM/Test",
                "dom:elem");
        attribute = newDoc.createAttribute("attr");
        element.setAttributeNode(attribute);
        elementDoc = newDoc.getDocumentElement();
        elementDoc.appendChild(element);
        elementList = newDoc.getElementsByTagNameNS(
                "http://www.w3.org/DOM/Test", "elem");
        elementTest = (Element) elementList.item(0);
        hasAttributes = elementTest.hasAttributes();
        assertTrue("nodehasattributes04", hasAttributes);
    }

}
