package org.osaf.caldav4j.methods;

import java.net.URI;

import org.osaf.caldav4j.CalDAVConstants;
import org.osaf.caldav4j.util.UrlUtils;

public class HttpDelete  extends org.apache.jackrabbit.webdav.client.methods.HttpDelete {

    /**
     * Default Constructor to delete at location specified by uri.
     * @param uri The location to the resource to be deleted.
     */
	public HttpDelete(URI uri) {
		this(uri, null);
	}

    /**
     * Constructor which takes in ETag along with URI.
     * This is for deleting a resource only with the specific ETag
     * @param uri Location to the resource on the server
     * @param etag ETag of the resource.
     */
    public HttpDelete(URI uri, String etag){
        super(uri);
        setETag(etag);
    }

	public HttpDelete(String uri) {
		this(URI.create(uri));
	}

	public HttpDelete(String uri, String etag) {
		this(URI.create(uri), etag);
	}

	/**
     * Sets the Request ETag for the DELETE method.
     * @param etag
     */
    public void setETag(String etag){
        if(etag != null && !etag.equals(""))
            setHeader(CalDAVConstants.HEADER_IF_MATCH, etag);
    }
	
	
}
