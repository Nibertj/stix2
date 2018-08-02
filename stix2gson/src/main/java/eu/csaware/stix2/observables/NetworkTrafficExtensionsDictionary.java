
package eu.csaware.stix2.observables;


import eu.csaware.stix2.common.Dictionary;

public class NetworkTrafficExtensionsDictionary  extends Dictionary {


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NetworkTrafficExtensionsDictionary.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NetworkTrafficExtensionsDictionary) == false) {
            return false;
        }
        NetworkTrafficExtensionsDictionary rhs = ((NetworkTrafficExtensionsDictionary) other);
        return true;
    }

}
