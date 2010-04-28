/*
 * Copyright 2010 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.simpledb;

import com.amazonaws.*;
import com.amazonaws.services.simpledb.model.*;

/**
 * Interface for accessing AmazonSimpleDB.
 * <p>
 * Amazon SimpleDB is a web service providing the core database
 * functions of data indexing and querying in the cloud. By offloading
 * the time and effort associated with building and operating a web-scale
 * database, SimpleDB provides developers the freedom to focus on
 * application development.
 * </p>
 * <p>
 * A traditional, clustered relational database requires a sizable
 * upfront capital outlay, is complex to design, and often requires
 * extensive and repetitive database administration. Amazon SimpleDB is
 * dramatically simpler, requiring no schema, automatically indexing your
 * data and providing a simple API for storage and access. This approach
 * eliminates the administrative burden of data modeling, index
 * maintenance, and performance tuning. Developers gain access to this
 * functionality within Amazon's proven computing environment, are able
 * to scale instantly, and pay only for what they use.
 * </p>
 * <p>
 * Visit <a href="http://aws.amazon.com/simpledb/">
 * http://aws.amazon.com/simpledb/ </a> for more information.
 * </p>
 */
public interface AmazonSimpleDB {

    /**
     * Overrides the default endpoint for this client ("https://sdb.amazonaws.com").
     * Callers can use this method to control which AWS region they want to work with.
     * <p>
     * Callers can pass in just the endpoint (ex: "ec2.amazonaws.com") or a full
     * URL, including the protocol (ex: "https://ec2.amazonaws.com"). If the
     * protocol is not specified here, the default protocol from this client's
     * {@link ClientConfiguration} will be used, which by default is HTTPS.
     *
     * @param endpoint
     *            The endpoint (ex: "ec2.amazonaws.com") or a full URL,
     *            including the protocol (ex: "https://ec2.amazonaws.com") of
     *            the region specific AWS endpoint this client will communicate
     *            with.
     *
     * @throws IllegalArgumentException
     *             If any problems are detected with the specified endpoint.
     */
    public void setEndpoint(String endpoint) throws java.lang.IllegalArgumentException;
    
    /**
     * <p>
     * The Select operation returns a set of Attributes for ItemNames that
     * match the select expression. Select is similar to the standard SQL
     * SELECT statement.
     * </p>
     * <p>
     * The total size of the response cannot exceed 1 MB in total size.
     * Amazon SimpleDB automatically adjusts the number of items returned per
     * page to enforce this limit. For example, even if you ask to retrieve
     * 2500 items, but each individual item is 10 kB in size, the system
     * returns 100 items and an appropriate next token so you can get the
     * next page of results.
     * </p>
     * <p>
     * For information on how to construct select expressions, see Using
     * Select to Create Amazon SimpleDB Queries in the Developer Guide.
     * </p>
     *
     * @param selectRequest Container for the necessary parameters to execute
     *           the Select service method on AmazonSimpleDB.
     * 
     * @return The response from the Select service method, as returned by
     *         AmazonSimpleDB.
     * 
     * @throws InvalidParameterValueException
     * @throws InvalidQueryExpressionException
     * @throws RequestTimeoutException
     * @throws InvalidNumberPredicatesException
     * @throws NoSuchDomainException
     * @throws InvalidNextTokenException
     * @throws TooManyRequestedAttributesException
     * @throws MissingParameterException
     * @throws InvalidNumberValueTestsException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SelectResult select(SelectRequest selectRequest) 
            throws AmazonServiceException, AmazonClientException;

    /**
     * <p>
     * The PutAttributes operation creates or replaces attributes in an
     * item. You specify new attributes using a combination of the
     * <code>Attribute.X.Name</code> and <code>Attribute.X.Value</code>
     * parameters. You specify the first attribute by the parameters
     * <code>Attribute.0.Name</code> and <code>Attribute.0.Value</code> ,
     * the second attribute by the parameters <code>Attribute.1.Name</code>
     * and <code>Attribute.1.Value</code> , and so on.
     * </p>
     * <p>
     * Attributes are uniquely identified in an item by their name/value
     * combination. For example, a single item can have the attributes
     * <code>{ "first_name", "first_value" }</code> and <code>{ "first_name",
     * second_value" }</code> . However, it cannot have two attribute
     * instances where both the <code>Attribute.X.Name</code> and
     * <code>Attribute.X.Value</code> are the same.
     * </p>
     * <p>
     * Optionally, the requestor can supply the Replace parameter for each
     * individual attribute. Setting this value to true causes the new
     * attribute value to replace the existing attribute value(s). For
     * example, if an item has the attributes <code>{ 'a', '1' }</code> ,
     * 
     * <code>{ 'b', '2'}</code> and <code>{ 'b', '3'
     * }</code> and the requestor calls PutAttributes using the attributes
     * <code>{ 'b', '4' }</code> with the Replace parameter set to true, the
     * final attributes of the item are changed to <code>{ 'a', '1' }</code>
     * and <code>{ 'b', '4' }</code> , which replaces the previous values of
     * the 'b' attribute with the new value.
     * </p>
     * <p>
     * <b>NOTE:</b> Using PutAttributes to replace attribute values that do
     * not exist will not result in an error response.
     * </p>
     * <p>
     * You cannot specify an empty string as an attribute name.
     * </p>
     * <p>
     * Because Amazon SimpleDB makes multiple copies of your data and uses
     * an eventual consistency update model, an immediate GetAttributes or
     * Select request (read) immediately after a DeleteAttributes request
     * (write) might not return the updated data.
     * </p>
     * <p>
     * The following limitations are enforced for this operation:
     * <ul>
     * <li>256 total attribute name-value pairs per item</li>
     * <li>One billion attributes per domain</li>
     * <li>10 GB of total user data storage per domain</li>
     * 
     * </ul>
     * 
     * </p>
     *
     * @param putAttributesRequest Container for the necessary parameters to
     *           execute the PutAttributes service method on AmazonSimpleDB.
     * 
     * @throws InvalidParameterValueException
     * @throws NumberDomainBytesExceededException
     * @throws NumberDomainAttributesExceededException
     * @throws NoSuchDomainException
     * @throws NumberItemAttributesExceededException
     * @throws AttributeDoesNotExistException
     * @throws MissingParameterException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void putAttributes(PutAttributesRequest putAttributesRequest) 
            throws AmazonServiceException, AmazonClientException;

    /**
     * <p>
     * The DeleteDomain operation deletes a domain. Any items (and their
     * attributes) in the domain are deleted as well. The DeleteDomain
     * operation might take 10 or more seconds to complete.
     * </p>
     * <p>
     * <b>NOTE:</b> Running DeleteDomain on a domain that does not exist or
     * running the function multiple times using the same domain name will
     * not result in an error response.
     * </p>
     *
     * @param deleteDomainRequest Container for the necessary parameters to
     *           execute the DeleteDomain service method on AmazonSimpleDB.
     * 
     * @throws MissingParameterException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteDomain(DeleteDomainRequest deleteDomainRequest) 
            throws AmazonServiceException, AmazonClientException;

    /**
     * <p>
     * The CreateDomain operation creates a new domain. The domain name must
     * be unique among the domains associated with the Access Key ID provided
     * in the request. The CreateDomain operation may take 10 or more seconds
     * to complete.
     * </p>
     * <p>
     * <b>NOTE:</b> CreateDomain is an idempotent operation; running it
     * multiple times using the same domain name will not result in an error
     * response.
     * </p>
     * <p>
     * You can create up to 100 domains per account.
     * </p>
     * <p>
     * If you require additional domains, go to <a
     * href="http://aws.amazon.com/contact-us/simpledb-limit-request/">
     * http://aws.amazon.com/contact-us/simpledb-limit-request/ </a> .
     * </p>
     *
     * @param createDomainRequest Container for the necessary parameters to
     *           execute the CreateDomain service method on AmazonSimpleDB.
     * 
     * @throws InvalidParameterValueException
     * @throws NumberDomainsExceededException
     * @throws MissingParameterException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void createDomain(CreateDomainRequest createDomainRequest) 
            throws AmazonServiceException, AmazonClientException;

    /**
     * <p>
     * Deletes one or more attributes associated with the item. If all
     * attributes of an item are deleted, the item is deleted.
     * </p>
     * <p>
     * <b>NOTE:</b> If you specify DeleteAttributes without attributes or
     * values, all the attributes for the item are deleted.
     * </p>
     * <p>
     * DeleteAttributes is an idempotent operation; running it multiple
     * times on the same item or attribute does not result in an error
     * response.
     * </p>
     * <p>
     * Because Amazon SimpleDB makes multiple copies of your data and uses
     * an eventual consistency update model, performing a GetAttributes or
     * Select request (read) immediately after a DeleteAttributes or
     * PutAttributes request (write) might not return the updated data.
     * </p>
     *
     * @param deleteAttributesRequest Container for the necessary parameters
     *           to execute the DeleteAttributes service method on AmazonSimpleDB.
     * 
     * @throws InvalidParameterValueException
     * @throws NoSuchDomainException
     * @throws AttributeDoesNotExistException
     * @throws MissingParameterException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteAttributes(DeleteAttributesRequest deleteAttributesRequest) 
            throws AmazonServiceException, AmazonClientException;

    /**
     * <p>
     * The ListDomains operation lists all domains associated with the
     * Access Key ID. It returns domain names up to the limit set by
     * MaxNumberOfDomains. A NextToken is returned if there are more than
     * MaxNumberOfDomains domains. Calling ListDomains successive times with
     * the NextToken returns up to MaxNumberOfDomains more domain names each
     * time.
     * </p>
     *
     * @param listDomainsRequest Container for the necessary parameters to
     *           execute the ListDomains service method on AmazonSimpleDB.
     * 
     * @return The response from the ListDomains service method, as returned
     *         by AmazonSimpleDB.
     * 
     * @throws InvalidParameterValueException
     * @throws InvalidNextTokenException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListDomainsResult listDomains(ListDomainsRequest listDomainsRequest) 
            throws AmazonServiceException, AmazonClientException;

    /**
     * <p>
     * Returns all of the attributes associated with the item. Optionally,
     * the attributes returned can be limited to one or more specified
     * attribute name parameters.
     * </p>
     * <p>
     * If the item does not exist on the replica that was accessed for this
     * operation, an empty set is returned. The system does not return an
     * error as it cannot guarantee the item does not exist on other
     * replicas.
     * </p>
     * <p>
     * <b>NOTE:</b> If you specify GetAttributes without any attribute names,
     * all the attributes for the item are returned.
     * </p>
     *
     * @param getAttributesRequest Container for the necessary parameters to
     *           execute the GetAttributes service method on AmazonSimpleDB.
     * 
     * @return The response from the GetAttributes service method, as
     *         returned by AmazonSimpleDB.
     * 
     * @throws InvalidParameterValueException
     * @throws NoSuchDomainException
     * @throws MissingParameterException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetAttributesResult getAttributes(GetAttributesRequest getAttributesRequest) 
            throws AmazonServiceException, AmazonClientException;

    /**
     * <p>
     * The BatchPutAttributes operation creates or replaces attributes
     * within one or more items.
     * </p>
     * <p>
     * You specify the item name with the <code>Item.X.ItemName</code>
     * parameter. You specify new attributes using a combination of the
     * <code>Item.X.Attribute.Y.Name</code> and
     * <code>Item.X.Attribute.Y.Value</code> parameters. You specify the
     * first attribute for the first item by the parameters
     * <code>Item.0.Attribute.0.Name</code> and
     * <code>Item.0.Attribute.0.Value</code> ,
     * the second attribute for the first item by the parameters
     * <code>Item.0.Attribute.1.Name</code> and
     * <code>Item.0.Attribute.1.Value</code> ,
     * and so on.
     * </p>
     * <p>
     * Attributes are uniquely identified within an item by their name/value
     * combination. For example, a single item can have the attributes
     * <code>{ "first_name", "first_value" }</code> and <code>{ "first_name",
     * "second_value" }</code> .
     * However, it cannot have two attribute instances where both the
     * <code>Item.X.Attribute.Y.Name</code> and
     * <code>Item.X.Attribute.Y.Value</code> are the same.
     * </p>
     * <p>
     * Optionally, the requester can supply the Replace parameter for each
     * individual value. Setting this value to true will cause the new
     * attribute value to replace the existing attribute value(s). For
     * example, if an item <code>I</code> has the attributes <code>{ 'a', '1'
     * }, { 'b', '2'}</code> and <code>{ 'b', '3' }</code> and the requester
     * does a BatchPutAttributes of <code>{'I', 'b', '4' }</code> with the
     * Replace parameter set to true, the final attributes of the item will
     * be <code>{ 'a', '1' }</code> and <code>{ 'b', '4' }</code> ,
     * replacing the previous values of the 'b' attribute with the new
     * value.
     * </p>
     * <p>
     * <b>NOTE:</b> You cannot specify an empty string as an item or
     * attribute name. The BatchPutAttributes operation succeeds or fails in
     * its entirety. There are no partial puts.
     * </p>
     * <p>
     * You can execute multiple BatchPutAttributes operations and other
     * operations in parallel. However, large numbers of concurrent
     * BatchPutAttributes calls can result in Service Unavailable (503)
     * responses.
     * </p>
     * <p>
     * The following limitations are enforced for this operation:
     * <ul>
     * <li>256 attribute name-value pairs per item</li>
     * <li>1 MB request size</li>
     * <li>1 billion attributes per domain</li>
     * <li>10 GB of total user data storage per domain</li>
     * <li>25 item limit per BatchPutAttributes operation</li>
     * 
     * </ul>
     * 
     * </p>
     *
     * @param batchPutAttributesRequest Container for the necessary
     *           parameters to execute the BatchPutAttributes service method on
     *           AmazonSimpleDB.
     * 
     * @throws DuplicateItemNameException
     * @throws InvalidParameterValueException
     * @throws NumberDomainBytesExceededException
     * @throws NumberSubmittedItemsExceededException
     * @throws NumberSubmittedAttributesExceededException
     * @throws NumberDomainAttributesExceededException
     * @throws NoSuchDomainException
     * @throws NumberItemAttributesExceededException
     * @throws MissingParameterException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void batchPutAttributes(BatchPutAttributesRequest batchPutAttributesRequest) 
            throws AmazonServiceException, AmazonClientException;

    /**
     * <p>
     * Returns information about the domain, including when the domain was
     * created, the number of items and attributes, and the size of attribute
     * names and values.
     * </p>
     *
     * @param domainMetadataRequest Container for the necessary parameters to
     *           execute the DomainMetadata service method on AmazonSimpleDB.
     * 
     * @return The response from the DomainMetadata service method, as
     *         returned by AmazonSimpleDB.
     * 
     * @throws NoSuchDomainException
     * @throws MissingParameterException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DomainMetadataResult domainMetadata(DomainMetadataRequest domainMetadataRequest) 
            throws AmazonServiceException, AmazonClientException;

    /**
     * <p>
     * The ListDomains operation lists all domains associated with the
     * Access Key ID. It returns domain names up to the limit set by
     * MaxNumberOfDomains. A NextToken is returned if there are more than
     * MaxNumberOfDomains domains. Calling ListDomains successive times with
     * the NextToken returns up to MaxNumberOfDomains more domain names each
     * time.
     * </p>
     * 
     * @return The response from the ListDomains service method, as returned
     *         by AmazonSimpleDB.
     * 
     * @throws InvalidParameterValueException
     * @throws InvalidNextTokenException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListDomainsResult listDomains() throws AmazonServiceException, AmazonClientException;
    
}
        