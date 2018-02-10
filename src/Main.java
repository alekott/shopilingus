public class Main {
    public static void main(String[] args) {
        ShoppingCenter galeria = new ShoppingCenter("galeria Rzeszow", "ul. pilsudskiego");
        Shop sklepik = new Shop("sklepik", 3, 24);
        galeria.addShop(sklepik);
        Product banan = new Product("banan", 3.20, "spozywcze", 0.07);
        Product jablko = new Product("jablko", 3.40, "spozywcze", 0.07);
        sklepik.addProduct(banan, 4);
        sklepik.addProduct(jablko, 5);
        sklepik.deleteProduct(banan.id);
        sklepik.deleteProduct(jablko.id);









    }
}
