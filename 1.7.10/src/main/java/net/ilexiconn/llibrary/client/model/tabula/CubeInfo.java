package net.ilexiconn.llibrary.client.model.tabula;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author iChun
 */
public class CubeInfo
{
    public String name;
    public int[] dimensions = new int[3];

    public double[] position = new double[3];
    public double[] offset = new double[3];
    public double[] rotation = new double[3];

    public double[] scale = new double[3];

    public int[] txOffset = new int[2];
    public boolean txMirror = false;

    public double mcScale = 0d;

    public double opacity = 100d;

    public boolean hidden = false;

    public ArrayList<CubeInfo> children = Lists.newArrayList();
    public String parentIdentifier;

    public String identifier;
}

