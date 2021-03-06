package com.example.vkontact;

public class Workout {
    private String name;
    private String descriptionList;
    private String description;
    private int imageResourceId;

    static final Workout[] workouts = {
            new Workout(SlimApp.context.getString(R.string.trikonasana_name),
                    SlimApp.context.getString(R.string.trikonasanaList),
                    SlimApp.context.getString(R.string.trikonasana),
                    R.drawable.trikonasana),
            new Workout(SlimApp.context.getString(R.string.virabxadrasana_name),
                    SlimApp.context.getString(R.string.virabxadrasanaList),
                    SlimApp.context.getString(R.string.virabxadrasana),
                    R.drawable.virabxadrasana),
            new Workout(SlimApp.context.getString(R.string.virabxadrasana_one_name),
                    SlimApp.context.getString(R.string.virabxadrasana_oneList),
                    SlimApp.context.getString(R.string.virabxadrasana_one),
                    R.drawable.virabxadrasana_one),
            new Workout(SlimApp.context.getString(R.string.bxudzhangasana_name),
                    SlimApp.context.getString(R.string.bxudzhangasanaList),
                    SlimApp.context.getString(R.string.bxudzhangasana),
                    R.drawable.bxudzhangasana),
            new Workout(SlimApp.context.getString(R.string.navasana_name),
                    SlimApp.context.getString(R.string.navasanaList),
                    SlimApp.context.getString(R.string.navasana),
                    R.drawable.navasana),
            new Workout(SlimApp.context.getString(R.string.gomukxasana_name),
                    SlimApp.context.getString(R.string.gomukxasanaList),
                    SlimApp.context.getString(R.string.gomukxasana),
                    R.drawable.gomukxasana),
            new Workout(SlimApp.context.getString(R.string.radzhakapotasana_name),
                    SlimApp.context.getString(R.string.radzhakapotasanaList),
                    SlimApp.context.getString(R.string.radzhakapotasana),
                    R.drawable.radzhakapotasana),
            new Workout(SlimApp.context.getString(R.string.bhekasana_name),
                    SlimApp.context.getString(R.string.bhekasanaList),
                    SlimApp.context.getString(R.string.bhekasana),
                    R.drawable.bhekasana),
            new Workout(SlimApp.context.getString(R.string.shavasana_name),
                    SlimApp.context.getString(R.string.shavasanaList),
                    SlimApp.context.getString(R.string.shavasana),
                    R.drawable.shavasana),
            new Workout(SlimApp.context.getString(R.string.pashchimottanasana_name),
                    SlimApp.context.getString(R.string.pashchimottanasanaList),
                    SlimApp.context.getString(R.string.pashchimottanasana),
                    R.drawable.pashchimottanasana),
            new Workout(SlimApp.context.getString(R.string.virabxadrasanathree_name),
                    SlimApp.context.getString(R.string.virabxadrasanathreeList),
                    SlimApp.context.getString(R.string.virabxadrasanathree),
                    R.drawable.virabxadrasanathree),
//            new Workout(SlimApp.context.getString(R.string._name),
//                    SlimApp.context.getString(R.string.List),
//                    SlimApp.context.getString(R.string.),
//                    R.drawable.),

    };

    private Workout(String name, String descriptionList, String description, int imageResourceId) {
        this.name = name;
        this.descriptionList = descriptionList;;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }
    String getName() {
        return name;
    }
    String getDescriptionList(){
        return descriptionList;
    }
    String getDescription() {
        return description;

    }
    int getImageResourceId() {
        return imageResourceId;
    }
}

