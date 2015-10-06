package aexbanner;

import java.util.ArrayList;
import java.util.List;

public class FondsGetter implements IEffectenbeurs {

    @Override
    public List<IFonds> getKoersen() {
        ArrayList<IFonds> fonds = new ArrayList<>();
        fonds.add(new Fonds("AEX", 439.666));
        fonds.add(new Fonds("ASML", 80.200));
        fonds.add(new Fonds("Delta Lloyd", 8.044));
        return fonds;

    }
}
