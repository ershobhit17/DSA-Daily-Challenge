class FoodRatings {
    // Map food name to its Food object
    private Map<String, Food> foodMap;
    // Map cuisine to a TreeSet of Food objects sorted by rating (desc) and name (asc)
    private Map<String, TreeSet<Food>> cuisineMap;
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);
            
            // Add to cuisine map
            cuisineMap.computeIfAbsent(cuisines[i], k -> new TreeSet<>(
                (a, b) -> {
                    if (a.rating != b.rating) {
                        return Integer.compare(b.rating, a.rating); // Higher rating first
                    }
                    return a.name.compareTo(b.name); // Lexicographically smaller name first
                }
            )).add(food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food foodObj = foodMap.get(food);
        
        // Remove from cuisine set
        cuisineMap.get(foodObj.cuisine).remove(foodObj);
        
        // Update rating
        foodObj.rating = newRating;
        
        // Add back to cuisine set with new rating
        cuisineMap.get(foodObj.cuisine).add(foodObj);
    }
    
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }
    
    // Helper class
    class Food {
        String name;
        String cuisine;
        int rating;
        
        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
}