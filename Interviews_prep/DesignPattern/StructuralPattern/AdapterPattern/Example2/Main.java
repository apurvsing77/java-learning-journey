package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adaptee.FitStrideProAPI;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adaptee.HealthBandXAPI;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adapter.FitStrideProAPIAdapter;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adapter.HealthBandXAPIAdapter;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Client.WeightManagementSystem;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Taget.FitnessTracker;

public class Main {
    public static void main(String[] args) {


        // Scenario 1: Using FitStride Pro data
        System.out.println("Integrating FitStride Pro Tracker:");
        FitStrideProAPI fitStrideProDevice = new FitStrideProAPI();
        FitnessTracker fitStrideProAdapter = new FitStrideProAPIAdapter(fitStrideProDevice);
        WeightManagementSystem wms = new WeightManagementSystem(fitStrideProAdapter);

        wms.proCaseFitnesdata();

        System.out.println("Integrating HealthBand X Tracker:");
        HealthBandXAPI healthBandXDevice = new HealthBandXAPI();
        FitnessTracker healthBandXAdapter = new HealthBandXAPIAdapter(healthBandXDevice);
        WeightManagementSystem wms2 = new WeightManagementSystem(healthBandXAdapter);
        wms2.proCaseFitnesdata();
    }
}
