## Oppgave - DevOps

Med DevOps som arbeidsmåte i tankene- Hvilke forbedringer kan teamet gjøre med fokus på måten de jobber med kildekode og versjonskontroll?



### Drøft

* Beskriv med ord eller skjermbilder hvordan man kan konfigurere GitHub på en måte som gir bedre kontroll på utviklingsprosessen. Spesielt med tanke på å hindre kode som ikke kompilerer og feilende tester fra å bli integrert i _main_ branch.

Når du har opprettet et github repo kan du som admin gå til Settings > Branches > skriv inn navnet på den branchen du ønsker å ha regler på, eks: main > Add rule
![rules](Images/rules.png)
![rules-status](Images/rules_status.png)

Her finnes det flere regler du kan huke av på for å øke både kontroll og unngå å ha feilende kode i dev. Disse reglene som er i det øverste bildet er veldig greie og burde være huket av på, man burde også ta et møte med teamet sitt der man diskuterer hvilke regler som passer for dem, og hvordan man skal forholde seg til de.
I bildet under kan man spesifisere at man ønsker at koden som skal inn til main branchen skal være up to date med det som allerede er der, da unngår man også merge-conflicts.

*Beskriv med ord eller skjermbilder hvordan GitHub kan konfigureres for å sikre at minst ett annet medlem av teamet har godkjent en pull request før den merges.
Se punkt 1 på skjermbildet over, der vil det kreves en pullrequest for at man skal kunne merge kode inn i main branchen.
![rules_pr](Images/rules_pr.png)
Her kan man definere hvor mange som skal godkjenne koden din i tillegg til andre punkter som kan være svært nyttige for team dino.

* Beskriv hvordan arbeidsflyten for hver enkelt utvikler bør være for å få en effektiv som mulig utviklingsprosess, spesielt hvordan hver enkelt utvikler bør jobbe med Brancher i Github hver gang han eller hun starter en ny oppgave.
