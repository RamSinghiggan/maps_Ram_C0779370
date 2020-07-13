package com.example.maps_ram_c0779370;



import com.google.android.gms.maps.model.LatLng;

import java.util.Vector;
import java.util.*;


public class VectorJar {


    public static int orientation(LatLng r1, LatLng r2,
                                  LatLng r3)
    {

        double val = (r2.longitude - r1.longitude) * (r3.latitude - r2.latitude) -
                (r2.latitude - r1.latitude) * (r3.longitude - r2.longitude);

        if (val == 0) return 0;

        return (val > 0)? 1: 2;
    }


    public static Vector<LatLng> convexHull(LatLng markers[], int n)
    {

        Vector<LatLng> ch = new Vector<LatLng>();


        if (n < 3){
            ch.addAll(Arrays.asList(markers));
            return ch;
        }

        int l = 0;
        for (int i = 1; i < n; i++)
            if (markers[i].latitude < markers[l].latitude)
                l = i;


        int p = l, q;
        do
        {

            ch.add(markers[p]);

            q = (p + 1) % n;

            for (int i = 0; i < n; i++)
            {

                if (orientation(markers[p], markers[i], markers[q])
                        == 2)
                    q = i;
            }

            p = q;

        } while (p != l);


        return ch;
    }


}
