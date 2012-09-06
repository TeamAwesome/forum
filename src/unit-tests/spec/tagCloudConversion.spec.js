describe("tagCloudConvert", function() {
    it("should convert Tag objects into jQCloud words", function() {
        var tagObjects = [
            {id: 1, value: "food", count: 10},
            {id: 2, value: "movie", count: 20}
        ];
        var words = tagCloudConvert(tagObjects);

        expect(words).toEqual([
            {text: "food", weight: 10, link: "/forum/tag/food"},
            {text: "movie", weight: 20, link: "/forum/tag/movie"},
        ]);
    });
});