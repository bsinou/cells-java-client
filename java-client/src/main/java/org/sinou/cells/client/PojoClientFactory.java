package org.sinou.cells.client;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.Store;
import com.pydio.cells.api.Transport;
import com.pydio.cells.client.CellsClient;
import com.pydio.cells.client.ClientFactory;
import com.pydio.cells.legacy.P8Client;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.ClientData;
import com.pydio.cells.transport.ServerFactory;
import com.pydio.cells.transport.auth.Token;

import org.sinou.cells.s3.PojoS3Client;

/**
 * Extend a server factory to manage client concepts.
 */
public class PojoClientFactory extends ClientFactory {

    public PojoClientFactory(Store<Token> tokenStore, Store<Server> serverStore, Store<Transport> transportStore) {
        super(tokenStore, serverStore, transportStore);
    }

    /**
     * Creates a factory with in memory stores for tokens, servers and transports
     */
    public PojoClientFactory() {
        super();
    }

    /**
     * Implement this: it is the single entry point to inject the S3 client
     * that is platform specific
     */
    protected CellsClient getCellsClient(CellsTransport transport){
        return new CellsClient(transport, new PojoS3Client(transport));
    };

    public Client getClient(Transport transport) {
        if (transport.getServer().isLegacy()) {
            return new P8Client(transport);
        } else {
            return getCellsClient((CellsTransport) transport);
        }
    }

    @Override
    protected void initAppData() {
        super.initAppData();
        ClientData.packageID = this.getClass().getPackage().getName();
        ClientData.name = "CellsJavaClient";
    }
}
