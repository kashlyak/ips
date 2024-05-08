An algorithm for counting unique IP addresses that are read from an external file.

## Algorithm Steps:

1. Initializing the BitSet Array.

2. Reading IP Addresses from File:
   An external file containing IP addresses is opened for reading. For each IP address in the file, the following actions are performed:
   - The IP address is split into four octets.
   - A reference to the corresponding BitSet object is obtained from the three-dimensional array.
   - The bit corresponding to the fourth octet of the IP address is set to one.

3. Counting Unique IP Addresses.

5. Outputting the Result.
