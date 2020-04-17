
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        // System.out.println(update.getMessage().getFrom().getFirstName() );

        String response = update.getMessage().getText();
        SendMessage message = new SendMessage();
        switch (response) {
            case "/start":

                System.out.println(update.getMessage().getFrom().getFirstName());
                message.setText("Salut " + update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName() +
                        "\nBine ai venit, sunt un bot in stadiu de elaborare 😎\nSarcina mea este sa te ajut sa afli cat mai  mult despre o persoana \n" +
                        "Pentru a afla mai multe despre aceasta persoana alege comenzi din lista de mai jos: \n" +
                        "/meniu\n" +
                        "/ce_face_el\n" +
                        "/despre_el\n" +
                        "/ce_mananca_el\n" +
                        "/cum_dau_de_el\n" +
                        "/vreau_sa_il_vad");
                trySend(message, update);
                break;
            case "/meniu":
                message.setText("  Meniul 😎  \n" +
                        "/meniu\n" +
                        "/ce_face_el\n" +
                        "/despre_el\n" +
                        "/ce_mananca_el\n" +
                        "/cum_dau_de_el\n" +
                        "/vreau_sa_il_vad");
                trySend(message, update);

                break;
            case "/ce_face_el":
                System.out.println(update.getMessage().getFrom().getFirstName());

                message.setText("Da ce face sta 😁");
                trySend(message, update);
                break;
            case "/despre_el":
                System.out.println(update.getMessage().getFrom().getFirstName());

                message.setText("Pai ce sa iti spun");
                trySend(message, update);
                message.setText("Cel mai bun coleg din lume 😎");
                trySend(message, update);
                message.setText("Vrode desteapt😂😂");
                trySend(message, update);
                message.setText("Acusa 20 de ani");
                trySend(message, update);
                message.setText("Invata la Utm la Marin😂😅");
                trySend(message, update);
                break;
            case "/ce_mananca_el":

                System.out.println(update.getMessage().getFrom().getFirstName());
                message.setText("Kebab de la twister bro😂");
                trySend(message, update);
                break;
            case "/cum_dau_de_el":

                System.out.println(update.getMessage().getFrom().getFirstName());

                message.setText("Greu de gasit😎\nhttps://www.facebook.com/kti23c");
                trySend(message, update);
                message.setText("Numa fii atent daca Cristina te prinde te taie🧨🩸🔪");
                trySend(message, update);
                break;
            case "/vreau_sa_il_vad":
                System.out.println(update.getMessage().getFrom().getFirstName());
                SendPhoto msg = new SendPhoto()
                        .setPhoto("AgACAgIAAxkBAAMGXpmWKPqkeA2foWA1WS_0L_eHcT0AApqtMRsSlMhIq9NAMPahLk7XvcIPAAQBAAMCAAN4AAPJ7gUAARgE")
                        .setCaption("Nu-i sexos oare ? 😉");
                trySendPhoto(msg, update);
                msg.setPhoto("AgACAgIAAxkBAAMIXpmWOpug29W0-voL4rYYiIRN1t4AAputMRsSlMhIuOupwB4Mi58ryX6RLgADAQADAgADeQADZzECAAEYBA")
                        .setCaption("Ce misterios 🤔");
                trySendPhoto(msg, update);
                msg.setPhoto("AgACAgIAAxkBAAMKXpmWSaYhXh4KZfQDHd1Tk_zq3D8AAp2tMRsSlMhInF5z_lAih8f5psIPAAQBAAMCAAN5AAMZxQYAARgE")
                        .setCaption("Iata si o poza cu baby ❤");
                trySendPhoto(msg, update);
                msg.setPhoto("AgACAgIAAxkBAAMMXpmWWfRC6SYUf1Zd2zwywqBLqncAAp6tMRsSlMhICaI8cpUsdFfex8IPAAQBAAMCAAN4AAP08wUAARgE")
                        .setCaption("Amu un cantec pentru Micu ⚡🎸🎸🎻🪕🎺🎹🔊♥");
                trySendPhoto(msg, update);
                msg.setPhoto("AgACAgIAAxkBAAMOXpmWbUKjQ_KO8bN6mXpKdBqqWK4AAp-tMRsSlMhIlNWsBNGPstRnsMIPAAQBAAMCAAN4AAM98wUAARgE")
                        .setCaption("Muschii lui 😏🤤");
                trySendPhoto(msg, update);
                break;
            default:
                message.setText("Alege ceva din meniu 😤😤");
                trySend(message, update);
                break;
        }
    }



    public String getBotUsername() {
        return "Garabagika_bot";
    }

    public String getBotToken() {
        return "1204357786:AAEE-PNjpXmbcUFbdQWpLaCOqwgr6Hf2LHI";
    }
    public void trySend(SendMessage message,Update update){
        message.setChatId(update.getMessage().getChatId());


        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void trySendPhoto(SendPhoto msg , Update update){
        msg.setChatId(update.getMessage().getChatId());
        try {
            execute(msg); // Call method to send the photo
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}


