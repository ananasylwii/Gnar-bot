package xyz.gnarbot.gnar.commands.executors.music.dj

import xyz.gnarbot.gnar.Bot
import xyz.gnarbot.gnar.commands.*
import xyz.gnarbot.gnar.commands.executors.music.MusicCommandExecutor
import xyz.gnarbot.gnar.music.MusicManager

@Command(
        aliases = ["stop", "leave"],
        description = "Stop and clear the music player."
)
@BotInfo(
        id = 61,
        category = Category.MUSIC,
        scope = Scope.VOICE,
        roleRequirement = "DJ"
)
class StopCommand : MusicCommandExecutor(false, false) {
    override fun execute(context: Context, label: String, args: Array<String>, manager: MusicManager) {
        manager.discordFMTrack = null
        Bot.getPlayers().destroy(context.guild.idLong)

        context.send().embed("Stop Playback") {
            desc { "Playback has been completely stopped and the queue has been cleared." }
        }.action().queue()
    }
}
