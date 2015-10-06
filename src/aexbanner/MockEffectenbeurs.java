package aexbanner;

import java.util.ArrayList;
import java.util.List;

public class MockEffectenbeurs implements IEffectenbeurs {

    @Override
    public List<IFonds> getKoersen() {

        ArrayList<IFonds> fonds = new ArrayList<>();
        fonds.add(new Fonds("AEX", 439.666));
        fonds.add(new Fonds("ASML", 80.200));
        fonds.add(new Fonds("Delta Lloyd", 8.044));
        return fonds;
    }

    @Override
    public String toString() {
        StringBuilder infoBuilder = new StringBuilder();
        for (IFonds fond : getKoersen()) {
            infoBuilder.append(fond.getNaam());
            infoBuilder.append(" - ");
            infoBuilder.append(String.valueOf(fond.getKoers()));
            infoBuilder.append(" ");
        }
        return infoBuilder.toString();
    }
}