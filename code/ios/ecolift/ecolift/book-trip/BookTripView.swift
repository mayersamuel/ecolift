import SwiftUI

struct BookTripView: View {
    @ObservedObject var viewModel: ViewModel
    var body: some View {
        VStack {
            Text("Book Trip")
                .font(.title)
                .padding(.top, 5)
                .padding(.bottom, 15)
            FromTo()
                .padding(.vertical, 20)
            Divider()
            Spacer()
            NavigationView {
                List {
                    ForEach(viewModel.trips, id: \.id) { trip in
                        NavigationLink(trip.id) {
                            TripListItem(trip: trip)
                        }
                    }
                }
            }
            Spacer()
        }
    }
}

#Preview {
    var model = Model()
    var viewModel = ViewModel(model: model)
    ContentView(selectedTab: 0, viewModel: viewModel)
}
